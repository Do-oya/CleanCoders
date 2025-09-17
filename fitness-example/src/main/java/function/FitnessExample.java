package function;

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class FitnessExample {
    public String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        return new TestableHtmlBuilder(pageData, includeSuiteSetup).invoke();
    }

    private class TestableHtmlBuilder {
        private final StringBuffer buffer;
        private PageData pageData;
        private boolean includeSuiteSetup;
        private WikiPage wikiPage;

        public TestableHtmlBuilder(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            wikiPage = pageData.getWikiPage();
            this.includeSuiteSetup = includeSuiteSetup;
            buffer = new StringBuffer();
        }

        public String invoke() throws Exception {
            if (pageData.hasAttribute("Test")) {
                includeSetups();
                buffer.append(pageData.getContent());
                includeTeardowns();
            }

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private void includeTeardowns() throws Exception {
            includeInherited("TearDown", "teardown");
            if (includeSuiteSetup)
                includeInherited(SuiteResponder.SUITE_TEARDOWN_NAME, "teardown");
        }

        private void includeSetups() throws Exception {
            if (includeSuiteSetup)
                includeInherited(SuiteResponder.SUITE_SETUP_NAME, "setup");
            includeInherited("SetUp", "setup");
        }

        private void includeInherited(String pageName, String mode) throws Exception {
            WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            if (suiteSetup != null) {
                includePage(suiteSetup, mode);
            }
        }

        private void includePage(WikiPage suiteSetup, String mode) throws Exception {
            WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
            String pagePathName = PathParser.render(pagePath);
            buffer.append("!include -" + mode + " .").append(pagePathName).append("\n");
        }
    }
}
