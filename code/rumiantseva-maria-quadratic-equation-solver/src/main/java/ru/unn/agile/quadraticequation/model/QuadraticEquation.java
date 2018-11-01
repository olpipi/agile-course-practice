package ru.unn.agile.quadraticequation.model;

public class QuadraticEquation {
    public static final double EPSILON = 0.000001;
    public static final int K = 4;

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(final double a, final double b, final double c) {
        if (a > EPSILON) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("Quadratic coefficient must not be equal to zero");
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void solve() {
        double d = Math.pow(b, 2) - K * a * c;

        if (d < 0) {
            throw new QuadraticEquationSolverException("Quadratic equation have no real roots");
        }
    }
}
