package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Circle implements Shape {

    private double radius;

    public Circle(final double radius) {

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
