package primefactors;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsTest {
    @Test
    void canFactorIntoPrimes() {
        assertThat(of(1)).isEqualTo(list());
    }

    private static List<Integer> list() {
        return Arrays.asList();
    }

    private List<Integer> of (int n) {
        return new ArrayList<>();
    }
}
