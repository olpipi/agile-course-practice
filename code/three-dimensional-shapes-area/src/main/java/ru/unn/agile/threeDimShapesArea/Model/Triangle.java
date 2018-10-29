package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
