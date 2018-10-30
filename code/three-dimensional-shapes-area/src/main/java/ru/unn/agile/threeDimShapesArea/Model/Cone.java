package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Cone implements Shape {
    private Circle base;
    private double height;

    public Cone(final double radius, final double height) {
        base = new Circle(radius);
        if (height <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.ILLEGAL_ARGUMENTS_EXCEPTION_STR);
        }
        this.height = height;
    }


    @Override
    public double getArea() {
        return base.getArea() + Math.PI * height * base.getRadius();
    }
}
