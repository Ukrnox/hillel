package com.babaian.homework.homework_06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FractionTest {
    private static Fraction fraction1;
    private static Fraction fraction2;
    private static Fraction fraction3;

    @BeforeAll
    static void setUp() {
        fraction1 = new FractionNumber(1, 3);
        fraction2 = new FractionNumber(2, 3);
        fraction3 = new FractionNumber(3, 4);
    }

    @Test
    void badFractionCreation() {
        assertThrows(IllegalArgumentException.class,() -> new FractionNumber(1,0));
    }

    @Test
    void testEquals() {
        assertEquals(new FractionNumber(1, 3), fraction1);
        assertNotEquals(fraction2, fraction1);
        assertEquals(new FractionNumber(3, 9), fraction1);
        assertEquals(new FractionNumber(3, 1), new FractionNumber(9, 3));
    }

    @Test
    void testPlusWithTheSameDenominator() {
        Fraction result = fraction1.plus(fraction2);
        assertEquals(new FractionNumber(3,3),result);
        assertEquals(new FractionNumber(1,1),result);
    }

    @Test
    void testPlusWithNotTheSameDenominator() {
        Fraction result = fraction1.plus(fraction3);
        assertEquals(new FractionNumber(13,12),result);
    }

    @Test
    void minus() {
        Fraction result = fraction1.minus(fraction2);
        Fraction result2 = fraction1.minus(fraction3);
        assertEquals(new FractionNumber(-1,3),result);
        assertEquals(new FractionNumber(-5,12),result2);
    }

    @Test
    void multiply() {
        Fraction result = fraction1.multiply(fraction2);
        Fraction result2 = fraction1.multiply(fraction3);
        assertEquals(new FractionNumber(2,9),result);
        assertEquals(new FractionNumber(3,12),result2);
    }

    @Test
    void divide() {
        Fraction result = fraction1.divide(fraction2);
        Fraction result2 = fraction1.divide(fraction3);
        assertEquals(new FractionNumber(1,2),result);
        assertEquals(new FractionNumber(4,9),result2);
    }
}