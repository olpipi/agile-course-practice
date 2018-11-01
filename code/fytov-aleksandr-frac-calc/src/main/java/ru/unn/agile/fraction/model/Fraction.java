package ru.unn.agile.fraction.model;

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
	
	@Override
    public String toString() {
        return String.format("%d/%d", num, denom);
    }
}
