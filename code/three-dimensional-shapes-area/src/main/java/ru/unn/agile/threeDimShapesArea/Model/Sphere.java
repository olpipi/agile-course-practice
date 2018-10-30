package ru.unn.agile.threeDimShapesArea.Model;


public class Sphere implements Shape {
    private double radius;
    private static final double SPHERE_AREA_COEF = 4 * Math.PI;

    public Sphere(final double radius) {
        if(radius <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.ILLEGAL_ARGUMENTS_EXCEPTION_STR);
        }

        this.radius = radius;
    }

    @Override
    public double getArea() {
        return SPHERE_AREA_COEF * radius * radius;
    }
}
