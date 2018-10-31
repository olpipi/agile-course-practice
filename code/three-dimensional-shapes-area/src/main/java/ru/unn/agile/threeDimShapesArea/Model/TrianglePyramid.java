package ru.unn.agile.threeDimShapesArea.Model;


public class TrianglePyramid implements Shape {

    private static final int TRIANGLE_PYRAMID_SIDES_COUNT = 3;
    private Triangle base;
    private Triangle side;

    public TrianglePyramid(final double baseSize, final double sideSize) {
        base = new Triangle(baseSize, baseSize, baseSize);
        side = new Triangle(sideSize, sideSize, baseSize);
    }

    @Override
    public double getArea() {
        return base.getArea() + TRIANGLE_PYRAMID_SIDES_COUNT * side.getArea();
    }
}
