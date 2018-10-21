package ru.unn.agile.primitives;

public class LineImpl implements Line {
    private Point point1;
    private Point point2;


    public LineImpl(final Point point1, final Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public double getLength() {
        Point point = point2.minus(point1);
        return Math.sqrt(Math.pow(point.getY(), 2)
                + Math.pow(point.getX(), 2));
    }

    @Override
    public String toString() {
        return "LineImpl{"
                + "point1=" + point1
                + ", point2=" + point2
                + ", length=" + getLength()
                + '}';
    }
}
