package primefactors;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsTest {
    @Test
    void canFactorIntoPrimes() {
        assertPrimeFactors(1, list());
        assertPrimeFactors(2, list(2));
        assertPrimeFactors(3, list(3));
        assertPrimeFactors(4, list(2, 2));
    }

    private void assertPrimeFactors(int n, List<Integer> list) {
        assertThat(of(n)).isEqualTo(list);
    }

    private static List<Integer> list(Integer... ints) {
        return Arrays.asList(ints);
    }

    private List<Integer> of (int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        if (n > 1) {
            if (n % 2 == 0) {
                factors.add(2);
                n /= 2;
            }
            if (n > 1)
                factors.add(n);
        }
        return factors;
    }
}
