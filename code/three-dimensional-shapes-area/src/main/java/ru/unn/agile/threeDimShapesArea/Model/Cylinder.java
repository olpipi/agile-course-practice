package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Cylinder implements Shape {
    private final double radius;
    private final double height;
    private static final double MULTIPLICATION_COEFFICIENT = 2 * Math.PI;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getArea() {
        return MULTIPLICATION_COEFFICIENT * radius * (radius + height);
    }
}
