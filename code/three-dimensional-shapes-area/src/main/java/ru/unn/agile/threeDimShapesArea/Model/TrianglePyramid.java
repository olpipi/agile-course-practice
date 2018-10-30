package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class TrianglePyramid implements Shape {
    private Triangle base;
    private Triangle side;
    private static final int TRIANGLE_PYRAMID_SIDES_COUNT = 3;

    public TrianglePyramid(final double baseSize, final double sideSize) {
        base = new Triangle(baseSize, baseSize, baseSize);
        side = new Triangle(sideSize, sideSize, baseSize);
    }

    @Override
    public double getArea() {
        return base.getArea() + TRIANGLE_PYRAMID_SIDES_COUNT * side.getArea();
    }
}
