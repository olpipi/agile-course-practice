package ru.unn.agile.intersect.model.objects;

public final class Point {
    public static final double EPSILON = 0.000001;
    private double coordinateX, coordinateY, coordinateZ;

    public Point(final double x1, final double y1, final double z1) {
        this.coordinateX = x1;
        this.coordinateY = y1;
        this.coordinateZ = z1;
    }

    public double getX() {
        return this.coordinateX;
    }

    public double getY() {
        return this.coordinateY;
    }

    public double getZ() {
        return this.coordinateZ;
    }

    public Point createVector(final Point pointA) {
        double x = this.getX() - pointA.getX();
        double y = this.getY() - pointA.getY();
        double z = this.getZ() - pointA.getZ();

        if (calculateDistance(pointA) > EPSILON) {
            return new Point(x, y, z);
        }
        return null;
    }

    public Point vectorProduct(final Point pointA) {
        double x = this.getY() * pointA.getZ() - this.getZ() * pointA.getY();
        double y = this.getZ() * pointA.getX() - this.getX() * pointA.getZ();
        double z = this.getX() * pointA.getY() - this.getY() * pointA.getX();
        return new Point(x, y, z);
    }

    public double scalarProduct(final Point pointA) {
        double scalarProduct = pointA.getX() * this.getX();
        scalarProduct += pointA.getY() * this.getY() + pointA.getZ() * this.getZ();
        return scalarProduct;
    }

    public double calculateDistance(final Point pointA) {
        double norm = Math.pow(pointA.getX() - this.getX(), 2) + Math.pow(pointA.getY() - this.getY(), 2) + Math.pow(pointA.getZ() - this.getZ(), 2);
        return Math.sqrt(norm);
    }

    public Point normalizePoint() {
        double norm = Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2);
        norm = Math.sqrt(norm);
        return new Point(this.getX() / norm, this.getY() / norm, this.getZ() / norm);
    }

}
