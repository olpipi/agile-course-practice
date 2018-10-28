package ru.unn.agile.segment2d.model;

import java.util.Objects;
import java.awt.geom.Point2D;

public class Segment2D {

    public static final double EPSILON = 0.000001;

    private Point2D p1;
    private Point2D p2;

    public Segment2D(final Point2D p1, final Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Segment2D(final double x1, final double y1, final double x2, final double y2) {
        this.p1 = new Point2D.Double(x1, y1);
        this.p2 = new Point2D.Double(x2, y2);
    }

    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public void setP1(final Point2D p1) {
        this.p1 = p1;
    }

    public void setP2(final Point2D p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Segment2D{"
                + "p1=" + p1.toString()
                + ", p2=" + p2.toString()
                + '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Segment2D) {
            Segment2D seg = (Segment2D) obj;
            return p1.distance(seg.p1) < EPSILON
                    && p2.distance(seg.p2) < EPSILON;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }

}
