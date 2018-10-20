package ru.unn.agile;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
         this.x = x;
         this.y = y;
    }

    public Point(Point point2D) {
        this.x = point2D.getX();
        this.y = point2D.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setB(double b) {
        this.y = y;
    }

    public Point minus(Point point){
        Point result = new Point(this);

        result.setX(point.getX() - result.getX());
        result.setB(point.getY() - result.getY());

        return result;
    }
}
