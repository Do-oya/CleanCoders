package wordwrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WrapperTest {
    @Test
    void should_wrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
    }

    private void assertWraps(String s, int width, String expected) {
        assertThat(wrap(s, width)).isEqualTo(expected);
    }

    private String wrap(String s, int width) {
        if (s == null)
            return "";
        return s;
    }
}
