package tdd_ch01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testFrancMultiplication() {
        Money five = Money.frank(5);
        assertEquals(Money.frank(10), five.times(2));
        assertEquals(Money.frank(15), five.times(3));
    }

    @Test
    void testEquality() {
        assertEquals(new Money(10, "CHF"), new Money(10, "CHF"));
        assertNotEquals(new Money(5, "CHF"), new Money(6, "CHF"));
        assertEquals(new Money(5, "USD"), new Money(5, "USD"));
        assertNotEquals(new Money(5, "USD"), new Money(6, "USD"));
        assertEquals(new Money(5, "USD"), new Money(5, "USD"));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency);
        assertEquals("CHF", Money.frank(1).currency);
    }
}
