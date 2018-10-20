package ru.unn.agile;

public class Point {

    private double x;
    private double y;

    public Point(final double x, final double y) {
         this.x = x;
         this.y = y;
    }

    public Point(final Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setB(final double b) {
        this.y = y;
    }

    public Point minus(final Point point) {
        Point result = new Point(this);

        result.setX(point.getX() - result.getX());
        result.setB(point.getY() - result.getY());

        return result;
    }
}
