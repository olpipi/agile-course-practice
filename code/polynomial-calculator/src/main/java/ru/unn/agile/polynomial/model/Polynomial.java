package ru.unn.agile.polynomial.model;

public class Polynomial {
    public static final double DELTA = 0.000001;

    private double[] coeffs;
    private int degree;

    public Polynomial() {
        this.coeffs = null;
        this.degree = -1;
    }

    public Polynomial(final double[] coef) {
        int firstElem = 0;
        while ((firstElem < coef.length) && (coef[firstElem] == 0)) {
            firstElem++;
        }
        if (firstElem == coef.length) {
            this.coeffs = null;
            this.degree = -1;
            return;
        }

        int length = coef.length - firstElem;
        this.coeffs = new double[length];
        for (int i = length; i > 0; i--) {
            this.coeffs[length - i] = coef[firstElem + (length - i)];
        }

        this.degree = length - 1;
    }

    public Polynomial(final Polynomial p) {
        degree = p.degree;
        coeffs = p.coeffs;
    }

    public double[] getCoeffs() {
        return this.coeffs;
    }

    public int getDegree() {
        return this.degree;
    }
}

