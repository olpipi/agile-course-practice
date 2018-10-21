package ru.unn.agile.vector3d.model;

public class Vector3D {
    public final static double EPSILON = 0.000001;

    private double x;
    private double y;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
