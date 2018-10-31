package ru.unn.agile.threeDimShapesArea.Model;


public class Circle implements Shape {

    private double radius;

    public Circle(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.ILLEGAL_ARGUMENTS_EXCEPTION_STR);
        }

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
