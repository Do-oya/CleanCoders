package wordwrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WrapperTest {
    @Test
    void should_wrap() {
        assertThat(wrap(null, 1)).isEqualTo("");
    }

    private String wrap(String s, int width) {
        return "";
    }
}
