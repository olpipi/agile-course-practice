package ru.unn.agile.fraction.model;

import java.util.Objects;

public class Fraction {
    private int num;
    private int denom;
	
    public Fraction(final int numerator, final int denominator) {
        this.num = numerator;
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
	
	private Fraction revert() {
        return (new Fraction(this.getDenominator(), this.getNumerator());
    }
	
	public Fraction multiply(final Fraction other) {
        return new Fraction(
                getNumerator() * other.getNumerator(),
                getDenominator() * other.getDenominator());
    }

    public Fraction divide(final Fraction other) {
        return this.multiply(other.revert());
    }
	
	@Override
    public String toString() {
        return String.format("%d/%d", num, denom);
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
}
