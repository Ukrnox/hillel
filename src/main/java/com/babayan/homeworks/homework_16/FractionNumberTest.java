package com.babayan.homeworks.homework_16;

import com.babayan.homeworks.homework_06.Fraction;
import com.babayan.homeworks.homework_06.FractionNumber;

import static org.junit.jupiter.api.Assertions.*;

class FractionNumberTest {
    private static Fraction fraction1 = new FractionNumber(1, 3);
    private static Fraction fraction2 = new FractionNumber(2, 3);
    private static Fraction fraction3 = new FractionNumber(3, 4);

    @MyTest
    public static void testEquals() {
        assertEquals(new FractionNumber(1, 3), fraction1);
        assertNotEquals(fraction2, fraction1);
        assertEquals(new FractionNumber(3, 9), fraction1);
        assertEquals(new FractionNumber(3, 1), new FractionNumber(9, 3));
    }

    @MyTest
    public static void testPlusWithTheSameDenominator() {
        Fraction result = fraction1.plus(fraction2);
        assertEquals(new FractionNumber(3,3),result);
        assertEquals(new FractionNumber(1,1),result);
    }

    @MyTest
    public static void testPlusWithNotTheSameDenominator() {
        Fraction result = fraction1.plus(fraction3);
        assertEquals(new FractionNumber(13,12),result);
    }

    @MyTest
    public static void minus() {
        Fraction result = fraction1.minus(fraction2);
        Fraction result2 = fraction1.minus(fraction3);
        assertEquals(new FractionNumber(-1,3),result);
        assertEquals(new FractionNumber(-5,12),result2);
    }

    @MyTest
    public static void multiply() {
        Fraction result = fraction1.multiply(fraction2);
        Fraction result2 = fraction1.multiply(fraction3);
        assertEquals(new FractionNumber(2,9),result);
        assertEquals(new FractionNumber(3,12),result2);
    }

    @MyTest
    public static void divide() {
        Fraction result = fraction1.divide(fraction2);
        Fraction result2 = fraction1.divide(fraction3);
        assertEquals(new FractionNumber(1,2),result);
        assertEquals(new FractionNumber(4,9),result2);
    }

    @MyTest
    public static void comDenominator() {
        assertEquals(fraction1.comDenominator(9,3),91);
    }

    @MyTest
    public static void comDivisor() {
        assertEquals(fraction1.comDivisor(3,3),31);
    }

    @MyTest
    public static void printToMixedFractions() {
        Fraction fraction = new FractionNumber(524,127);
        String result = "524/127 can be a mixed fraction: 4 and 16/127";
        assertEquals(fraction.printToMixedFractions(),result);
    }
}