package ru.unn.agile;

public class Vector {
    private Point point1;
    private Point point2;


    public Vector(final Point point1, final Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getLength() {
        return Math.sqrt(Math.abs(Math.pow(point2.minus(point1).getY(), 2)
                + Math.pow(point2.minus(point1).getX(), 2)));
    }
}
