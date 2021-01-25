package com.babaian.homework.homework_06;

public interface Fraction {

    int getNumerator();

    int getDenominator();

    Fraction plus(Fraction a);

    Fraction minus(Fraction a);

    Fraction multiply(Fraction a);

    Fraction divide(Fraction a);

    String printToMixedFractions();

    default int comDenominator(int a, int b) {
        int temp = a;
        while (a % b != 0) {
            a += temp;
        }
        return a;
    }

    default int comDivisor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }
}
