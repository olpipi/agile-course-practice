package ru.unn.agile.threeDimShapesArea.Model;


public class Cube implements Shape {
    private double side;
    private static final int SQUARES_COUNT = 6;

    public Cube(final double sideSize) {
        if (sideSize <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.ILLEGAL_ARGUMENTS_EXCEPTION_STR);
        }
        side = sideSize;
    }

    @Override
    public double getArea() {
        return SQUARES_COUNT * side * side;
    }
}
