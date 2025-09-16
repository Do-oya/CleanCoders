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
        assertPrimeFactors(5, list(5));
        assertPrimeFactors(6, list(2, 3));
        assertPrimeFactors(7, list(7));
        assertPrimeFactors(8, list(2, 2, 2));
        assertPrimeFactors(9, list(3, 3));
        assertPrimeFactors(2 * 2 * 3 * 3 * 3 * 7 * 7 * 11 * 11 * 13, list(2, 2, 3, 3, 3, 7, 7, 11, 11, 13));
    }

    private void assertPrimeFactors(int n, List<Integer> list) {
        assertThat(of(n)).isEqualTo(list);
    }

    private static List<Integer> list(Integer... ints) {
        return Arrays.asList(ints);
    }

    private List<Integer> of (int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        int divisor = 2;
        for (;n > 1; divisor++)
            for (;n % divisor == 0; n /= divisor)
                factors.add(divisor);
        return factors;
    }
}
