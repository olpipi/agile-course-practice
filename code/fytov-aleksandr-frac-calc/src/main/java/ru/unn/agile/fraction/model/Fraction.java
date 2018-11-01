package ru.unn.agile.fraction.model;

import java.util.Objects;

public class Fraction {
    private int num;
    private int denom;

    private Fraction revert() {
        return (this.getNumerator() < 0)
                ? new Fraction(-this.getDenominator(), Math.abs(getNumerator()))
                : new Fraction(this.getDenominator(), this.getNumerator());
    }

    public Fraction(final int numerator, final int denominator) {
        this.num = numerator;
        if (denominator < 0) {
           throw new ArithmeticException("Denominator cannot be less than zero!");
        }
        if (denominator == 0) {
           throw new ArithmeticException("Denominator cannot be zero!");
        }
        this.denom = denominator;
    }

    public void setNumerator(final int numerator) {
        this.num = numerator;
    }

    public int getNumerator() {
        return num;
    }

    public void setDenominator(final int denominator) {
        this.denom = denominator;
    }

    public int getDenominator() {
        return denom;
    }

    public Fraction addNoGcd(final Fraction other) {
        return new Fraction(
                getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator(),
                getDenominator() * other.getDenominator());
    }

    public Fraction multiply(final Fraction other) {
        return new Fraction(
                getNumerator() * other.getNumerator(),
                getDenominator() * other.getDenominator());
    }

    public Fraction divide(final Fraction other) {
        return this.multiply(other.revert());
    }

    //greatest common divisor
    public int getGcd(final int firstVal, final int secondVal) {
        if (secondVal == 0) {
            return Math.abs(firstVal);
        }
        return getGcd(secondVal, firstVal % secondVal);
    }

    public Fraction addWithGcd(final Fraction other) {
        int noGcdNum =
                getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator();
        int noGcdDenom = getDenominator() * other.getDenominator();
        int gcd = getGcd(noGcdNum, noGcdDenom);

        return new Fraction(noGcdNum / gcd, noGcdDenom / gcd);
    }

    public Fraction substract(final Fraction other) {
        int noGcdNum =
                getNumerator() * other.getDenominator() - other.getNumerator() * getDenominator();
        int noGcdDenom = getDenominator() * other.getDenominator();
        int gcd = getGcd(noGcdNum, noGcdDenom);

        return new Fraction(noGcdNum / gcd, noGcdDenom / gcd);
    }

    @Override
    public boolean equals(final Object object) {
        Fraction number = (Fraction) object;
        return number.getNumerator() == getNumerator()
                && number.getDenominator() == getDenominator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, denom);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", num, denom);
    }
}
