package test_technique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordwrapTest {
    @BeforeEach
    void setUp() {
        wordWrap = new WordWrap();
    }

    @Test
    void wrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
        assertWraps("x xx", 3, "x\nxx");
    }

    private void assertWraps(String s, int width, String value) {
        assertThat(wordWrap.wrap(s, width), is(value));
    }

    WordWrap wordWrap;
}
