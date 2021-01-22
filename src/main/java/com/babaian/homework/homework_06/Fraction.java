package com.babaian.homework.homework_06;

public interface Fraction <T> {

    int getNumerator();

    int getDenominator();

    T plus(T a);

    T minus(T a);

    T multiply(T a);

    T divide(T a);


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
