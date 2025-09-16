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
        assertThat(of(2)).isEqualTo(list(2));
        assertThat(of(3)).isEqualTo(list(3));
    }

    private static List<Integer> list(Integer... ints) {
        return Arrays.asList(ints);
    }

    private List<Integer> of (int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        if (n > 1)
            factors.add(n);
        return factors;
    }
}
