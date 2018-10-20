package ru.unn.agile;

public class Triangele {
    private Vector a;
    private Vector b;
    private Vector c;

    public Triangele(final Point point1, final Point point2, final Point point3) {
        if (!validate(point1,point2,point3)) {
            throw new IllegalArgumentException();
        }
        this.a = new Vector(point1, point2);
        this.b = new Vector(point2, point3);
        this.c = new Vector(point3, point1);
    }

    public double getLengthA() {
        return a.getLength();
    }

    public static boolean validate(final Point point1, final Point point2, final Point point3) {
        Vector vector1 = new Vector(point1, point2);
        if (vector1.getLength() == 0) {
            return false;
        }
        if ((point3.getX() - point1.getX()) * (point2.getY() - point1.getY())
                == (point3.getY() - point1.getY()) * (point2.getX() - point1.getX())) {
            return false;
        }
        return true;
    }
}
