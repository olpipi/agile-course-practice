package ru.unn.agile.threeDimShapesArea.Model;


public class Sphere implements Shape {
    private double radius;
    private static final double MULTIPLICATION_COEFFICIENT = 4 * Math.PI;

    public Sphere(final double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return MULTIPLICATION_COEFFICIENT * radius * radius;
    }
}
