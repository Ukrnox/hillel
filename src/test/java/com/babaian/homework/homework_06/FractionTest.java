package com.babaian.homework.homework_06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private static Fraction fraction;
    private static Fraction fraction2;
    private static Fraction fraction3;

    @BeforeEach
    void setUp() {
     fraction = new FractionNumber(3,3);
     fraction2 = new FractionNumber(1,3);
     fraction3 = new FractionNumber(3,4);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void plus() {
        var result = fraction.plus(fraction2);
        assertEquals(new FractionNumber(3,3),result);
    }

    @Test
    void minus() {
        var result = fraction.minus(fraction2);
        assertEquals(new FractionNumber(-1,3),result);
    }

    @Test
    void multiply() {
        var result = fraction.multiply(fraction2);
        assertEquals(new FractionNumber(2,9),result);
    }

    @Test
    void divide() {
        var result = fraction.divide(fraction2);
        assertEquals(new FractionNumber(3,6),result);
    }

    @Test
    void testPlusWithTheSameDenominator (){
        var result = fraction.multiply(fraction2);
        assertEquals(new FractionNumber(1,3),result);
    }


    @Test
    void comDenominator() {
    }

    @Test
    void comDivisor() {
    }
}