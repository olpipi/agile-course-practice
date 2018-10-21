package ru.unn.agile;

import ru.unn.agile.primitives.Line;
import ru.unn.agile.primitives.LineImpl;
import ru.unn.agile.primitives.Point;

import static java.lang.Math.*;

public class Triangele {
    private Line a;
    private Line b;
    private Line c;

    public Triangele(final Point point1,
                     final Point point2,
                     final Point point3) {
        if (!validate(point1, point2, point3)) {
            throw new IllegalArgumentException();
        }
        this.a = new LineImpl(point1, point2);
        this.b = new LineImpl(point2, point3);
        this.c = new LineImpl(point3, point1);
    }

    protected static boolean validate(final Point point1,
                                      final Point point2,
                                      final Point point3) {
        if (point1 == null
                || point2 == null
                || point3 == null)
            return false;
        return ((point3.getX() - point1.getX()) * (point2.getY() - point1.getY())
                != (point3.getY() - point1.getY()) * (point2.getX() - point1.getX()));
    }

    protected double angleBetweenTwoLines(final Line line1,
                                          final Line line2,
                                          final Line oppositeLine) {
        return acos(
                (pow(line1.getLength(), 2)
                        + pow(line2.getLength(), 2)
                        - pow(oppositeLine.getLength(), 2))
                        / (2 * line1.getLength() * line2.getLength())
        );
    }

    public double getLengthA() {
        return a.getLength();
    }

    public double getLengthB() {
        return b.getLength();
    }

    public double getLengthC() {
        return c.getLength();
    }

    public double getAngleAB() {
        return angleBetweenTwoLines(a, b, c);
    }

    public double getAngleBC() {
        return angleBetweenTwoLines(b, c, a);
    }

    public double getAngleCA() {
        return angleBetweenTwoLines(c, a, b);
    }

    public double getPerimeter() {
        return a.getLength() + b.getLength() + c.getLength();
    }

    public double getSquare() {
        return 0.5 * a.getLength() * b.getLength();
    }

    @Override
    public String toString() {
        return "Triangele{"
                + "a=" + a
                + ", b=" + b
                + ", c=" + c
                + '}';
    }
}
