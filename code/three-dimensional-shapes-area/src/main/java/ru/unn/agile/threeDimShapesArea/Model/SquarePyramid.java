package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class SquarePyramid implements Shape {
    private final double squareSide;
    private final double triangleSide;
    private static final int MULTIPLICATION_COEFFICIENT = 2;
    private static final int DIVISION_COEFFICIENT = 4;

    public SquarePyramid(final double squareSide, final double triangleSide) {
        this.squareSide = squareSide;
        this.triangleSide = triangleSide;
    }

    @Override
    public double getArea() {
        double baseArea = squareSide * squareSide;
        double trianglesArea = MULTIPLICATION_COEFFICIENT * squareSide
                * Math.sqrt(triangleSide * triangleSide - baseArea / DIVISION_COEFFICIENT);
        return baseArea
                + trianglesArea;

    }
}
