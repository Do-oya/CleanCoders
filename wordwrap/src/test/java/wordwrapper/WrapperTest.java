package wordwrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WrapperTest {
    @Test
    void should_wrap() {
        assertThat(wrap("word word", 4)).isEqualTo("word\nword");
    }

    private String wrap(String s, int length) {
        return null;
    }
}
