package ru.unn.agile.segment2d.model;

import java.util.Objects;
import java.awt.geom.Point2D;

public class Segment2D {

    public static final double EPSILON = 0.000001;

    private Point2D p1;
    private Point2D p2;

    /*Basic methods*/
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
            return (p1.distance(seg.p1) < EPSILON && p2.distance(seg.p2) < EPSILON)
                    || (p1.distance(seg.p2) < EPSILON && p2.distance(seg.p1) < EPSILON);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }


    /*Utils methods*/
    private boolean isValidSegment() {
        return p1.distance(p2) > EPSILON;
    }

    private double det(int a, int b, int c, int d) {
        return a * d - b * c;
    }

    private boolean between(double x1, double x2, double target) {
        return Math.min(x1, x2) <= target + EPSILON &&
                target <= Math.max(x1, x2) + EPSILON;
    }

    private boolean intersection1D(double p1_x1, double p1_x2, double p2_x1, double p2_x2) {
        double cur_p1_x1 = p1_x1;
        double cur_p1_x2 = p1_x2;
        double cur_p2_x1 = p2_x1;
        double cur_p2_x2 = p2_x2;

        if (p1_x1 > p1_x2) {
            cur_p1_x1 = p1_x2;
            cur_p1_x2 = p1_x1;
        }
        if (p2_x1 > p2_x2) {
            cur_p2_x1 = p2_x2;
            cur_p2_x2 = p2_x1;
        }

        return Math.max(cur_p1_x1, cur_p2_x1) <= Math.min(cur_p1_x2, cur_p2_x2);
    }

}
