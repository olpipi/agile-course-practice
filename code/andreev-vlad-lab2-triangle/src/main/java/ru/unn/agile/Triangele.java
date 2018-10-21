package ru.unn.agile;

import ru.unn.agile.primitives.Line;
import ru.unn.agile.primitives.LineImpl;
import ru.unn.agile.primitives.Point;

public class Triangele {
    private Line a;
    private Line b;
    private Line c;

    public Triangele(final Point point1, final Point point2, final Point point3) {
        if (!validate(point1, point2, point3)) {
            throw new IllegalArgumentException();
        }
        this.a = new LineImpl(point1, point2);
        this.b = new LineImpl(point2, point3);
        this.c = new LineImpl(point3, point1);
    }

    protected static boolean validate(final Point point1, final Point point2, final Point point3) {
        return ((point3.getX() - point1.getX()) * (point2.getY() - point1.getY())
                != (point3.getY() - point1.getY()) * (point2.getX() - point1.getX()));
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

}
