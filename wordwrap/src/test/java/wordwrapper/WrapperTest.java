package wordwrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WrapperTest {
    @Test
    void should_wrap() {

    }

    private String wrap(String s, int width) {
        return s.length() > width ? s.replaceAll(" ", "\n") : s;
    }
}
