package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class TrianglePrism implements Shape {

    private final Triangle base;
    private final double height;
    private static final int BASE_COUNT = 2;


    public TrianglePrism(final Triangle base, final double height) {
        this.base = base;
        this.height = height;
    }


    @Override
    public double getArea() {
        return BASE_COUNT * base.getArea()
                + height * base.getA()
                + height * base.getB()
                + height * base.getC();
    }
}
