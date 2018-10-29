package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Cones implements Shape {
    private Circle base;
    private double height;

    public Cones(final double radius, final double height) {
        base = new Circle(radius);
        this.height = height;
    }


    @Override
    public double getArea() {
        return base.getArea() +  Math.PI * height * base.getRadius();
    }
}
