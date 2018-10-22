package ru.unn.agile.ComplexNumber.Model;

import java.util.Objects;

public class ComplexNumber {

    public static double EPSILON = 0.000001;

    private double real;
    private double imaginary;

    public ComplexNumber(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setReal(final double real) {
        this.real = real;
    }

    public void setImaginary(final double imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexNumber add(final ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(final ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber multiply(final ComplexNumber other) {
        return new ComplexNumber(
                real * other.real - imaginary * other.imaginary,
                real * other.imaginary + imaginary * other.real);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Math.abs(that.real - real) < EPSILON && Math.abs(that.imaginary - imaginary) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }
}