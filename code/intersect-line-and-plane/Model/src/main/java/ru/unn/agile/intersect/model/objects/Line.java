package ru.unn.agile.intersect.model.objects;

public final class Line {
    private Point pointX, pointY;

    public Line(final Point pointA1, final Point pointB1) {
        if(pointA1.createVector(pointB1) != null) {
            this.pointX = pointA1;
            this.pointY = pointB1;
        } else {
            throw new ArithmeticException("Points must not have identical coordinates");
        }
    }

    public Point getX() {
        return this.pointX;
    }

    public Point getY() {
        return this.pointY;
    }
}
