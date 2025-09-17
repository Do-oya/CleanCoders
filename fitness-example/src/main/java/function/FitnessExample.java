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
                if (includeSuiteSetup) {
                    String pageName = SuiteResponder.SUITE_SETUP_NAME;
                    String mode = "setup";
                    WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
                    if (suiteSetup != null) {
                        includePage(suiteSetup, mode);
                    }
                }
                String setUp = "SetUp";
                String mode = "setup";
                WikiPage setup = PageCrawlerImpl.getInheritedPage(setUp, wikiPage);
                if (setup != null) {
                    includePage(setup, mode);
                }
            }

            buffer.append(pageData.getContent());
            if (pageData.hasAttribute("Test")) {
                String tearDown = "TearDown";
                String mode = "teardown";
                WikiPage teardown = PageCrawlerImpl.getInheritedPage(tearDown, wikiPage);
                if (teardown != null) {
                    includePage(teardown, mode);
                }
                if (includeSuiteSetup) {
                    String suiteTeardownName = SuiteResponder.SUITE_TEARDOWN_NAME;
                    String mode1 = "teardown";
                    WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(suiteTeardownName, wikiPage);
                    if (suiteTeardown != null) {
                        includePage(suiteTeardown, mode1);
                    }
                }
            }

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private void includePage(WikiPage suiteSetup, String mode) throws Exception {
            WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
            String pagePathName = PathParser.render(pagePath);
            buffer.append("!include -" + mode + " .").append(pagePathName).append("\n");
        }
    }
}
