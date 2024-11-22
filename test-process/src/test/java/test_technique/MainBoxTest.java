package test_technique;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainBoxTest {
    @Test
    public void newMainBox_should_empty() {
        MailBox mailBox = new MailBox();
        assertThat(mailBox.messageCount(), is(0));
    }
}
