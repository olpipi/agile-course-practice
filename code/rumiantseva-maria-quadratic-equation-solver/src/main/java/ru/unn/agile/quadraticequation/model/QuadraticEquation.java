package ru.unn.agile.quadraticequation.model;

public class QuadraticEquation {
    public static final double EPSILON = 0.000001;

    private double a;
    private double b;

    public QuadraticEquation(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
