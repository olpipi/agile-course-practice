package ru.unn.agile.threeDimShapesArea.Model;


public class Cylinder implements Shape {
    private final double radius;
    private final double height;
    private static final double CYLINDER_AREA_COEF = 2 * Math.PI;

    public Cylinder(final double radius, final double height) {
        if (height <= 0 || radius <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.ILLEGAL_ARGUMENTS_EXCEPTION_STR);
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getArea() {
        return CYLINDER_AREA_COEF * radius * (radius + height);
    }
}
