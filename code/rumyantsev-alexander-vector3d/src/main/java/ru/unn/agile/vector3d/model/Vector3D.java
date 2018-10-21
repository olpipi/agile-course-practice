package ru.unn.agile.vector3d.model;

public class Vector3D {
    public final static double EPSILON = 0.000001;

    double x;

    public Vector3D(double x, double y, double z) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
}
