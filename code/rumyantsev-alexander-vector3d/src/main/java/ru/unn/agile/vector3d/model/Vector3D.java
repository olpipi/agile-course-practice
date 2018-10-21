package ru.unn.agile.vector3d.model;

public class Vector3D {
    public final static double EPSILON = 0.000001;

    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Vector3D) {
            Vector3D otherVector = (Vector3D) obj;

            return Math.abs(this.x - otherVector.x) < Vector3D.EPSILON &&
                    Math.abs(this.y - otherVector.y) < Vector3D.EPSILON &&
                    Math.abs(this.z - otherVector.z) < Vector3D.EPSILON;
        }

        return false;
    }
}
