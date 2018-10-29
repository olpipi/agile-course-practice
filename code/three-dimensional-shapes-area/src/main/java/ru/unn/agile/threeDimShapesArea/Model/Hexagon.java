package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Hexagon implements Shape {
    private double a;
    private static final double MULTIPLICATION_COEF = 3 * Math.sqrt(3) / 2;

    public Hexagon(final double sideSize) {
        a = sideSize;
    }

    @Override
    public double getArea() {
        return MULTIPLICATION_COEF * a * a;
    }
}
