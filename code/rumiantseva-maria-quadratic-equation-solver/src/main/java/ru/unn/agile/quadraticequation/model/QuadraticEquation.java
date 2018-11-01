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

    public double[] solve() {
        double root1;
        double root2;
        double[] roots = new double[2];
        double d = Math.pow(b, 2) - K * a * c;

        if (d > 0) {
            root1 = (-b - Math.sqrt(d)) / (2.0 * a);
            root2 = (-b + Math.sqrt(d)) / (2.0 * a);
            if (root1 < root2) {
                roots[0] = root1;
                roots[1] = root2;
            } else {
                roots[0] = root2;
                roots[1] = root1;
            }
        } else {
            if (d < 0) {
                throw new QuadraticEquationSolverException("Quadratic equation have no real roots");
            } else {
                if (d == 0) {
                    for (int i = 0; i < roots.length; i++) {
                        roots[i] = -b / (2.0 * a);
                    }
                }
            }
        }
        return roots;
    }
}

