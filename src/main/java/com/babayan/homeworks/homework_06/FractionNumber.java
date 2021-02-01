package com.babayan.homeworks.homework_06;

import java.util.Objects;

public final class FractionNumber implements Fraction {

    private final int numerator;
    private final int denominator;

    public FractionNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Zero in the denominator!\u2639");
        }
        this.numerator = numerator / comDivisor(numerator, denominator);
        this.denominator = denominator / comDivisor(numerator, denominator);
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    @Override
    public Fraction plus(Fraction a) {
        int comDenominator = comDenominator(this.denominator, a.getDenominator());
        return new FractionNumber(((this.numerator * (comDenominator / this.denominator)) +
                (a.getNumerator() * comDenominator / a.getDenominator())), (comDenominator));
    }

    @Override
    public Fraction minus(Fraction a) {
        int comDenominator = comDenominator(this.denominator, a.getDenominator());
        return new FractionNumber(((this.numerator * (comDenominator / this.denominator)) -
                (a.getNumerator() * comDenominator / a.getDenominator())), (comDenominator));
    }

    @Override
    public Fraction multiply(Fraction a) {
        return new FractionNumber((this.numerator * a.getNumerator()), this.denominator * a.getDenominator());
    }

    @Override
    public Fraction divide(Fraction a) {
        return this.multiply(new FractionNumber(a.getDenominator(), a.getNumerator()));
    }

    @Override
    public String printToMixedFractions() {// добавил возможность вывода в консоль целого если оно есть ex: "-3 and 9/127"
        int whole = numerator / denominator;
        if (whole == 0) {
            return toString() + " is not a mixed fraction";
        }
        int comDivisor = comDivisor(numerator, denominator);
        int newDenominator = Math.abs(denominator / comDivisor);
        int newNumerator = Math.abs(numerator / comDivisor) % newDenominator;
        return toString() + " can be a mixed fraction: " + whole + " and " + newNumerator + "/" + newDenominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        FractionNumber that = (FractionNumber) a;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

}
