package ru.unn.agile.quadraticequation.model;

public class QuadraticEquation {
    public static final double EPSILON = 0.000001;

    private double a;

    public QuadraticEquation(final double a, final double b, final double c) {
        this.a = a;
    }

    public double getA() {
        return a;
    }
}
