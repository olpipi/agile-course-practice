package ru.unn.agile.threeDimShapesArea.Model;


public class Cube implements Shape {
    private double side;
    private static final int COUNT_OF_SQUARES = 6;

    public Cube(final double sideSize) {
        side = sideSize;
    }

    @Override
    public double getArea() {
        return COUNT_OF_SQUARES * side * side;
    }
}
