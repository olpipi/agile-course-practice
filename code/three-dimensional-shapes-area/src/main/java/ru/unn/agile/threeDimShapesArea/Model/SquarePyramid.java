package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class SquarePyramid implements Shape {
    private final double squareSide;

    private final Triangle triangleSide;
    private static final int TRIANGLES_COUNT = 4;

    public SquarePyramid(final double squareSide, final double triangleSide) {
        if(squareSide <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.ILLEGAL_ARGUMENTS_EXCEPTION_STR);
        }
        this.squareSide = squareSide;
        this.triangleSide = new Triangle(squareSide, triangleSide, triangleSide);
    }

    @Override
    public double getArea() {
        double baseArea = squareSide * squareSide;
        double trianglesArea = TRIANGLES_COUNT * triangleSide.getArea();
        return baseArea
                + trianglesArea;

    }
}
