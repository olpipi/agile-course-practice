package ru.unn.agile.segment2d.model;

import java.util.Objects;
import java.awt.geom.Point2D;
import java.util.Map;
import java.util.HashMap;

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


    /*Main methods*/
    public boolean isParallel(final Segment2D targetSegment) {
        if (!isValidSegment() || !targetSegment.isValidSegment()) {
            return false;
        }

        Map<String, Double> params = getParameters(targetSegment);
        double base = det(params.get("A1"), params.get("B1"), params.get("A2"), params.get("B2"));

        return base == 0;
    }

    public boolean isMatched(final Segment2D targetSegment) {
        if (!isValidSegment() || !targetSegment.isValidSegment()) {
            return false;
        }

        Map<String, Double> params = getParameters(targetSegment);
        double base = det(params.get("A1"), params.get("B1"), params.get("A2"), params.get("B2"));

        if (base != 0) {
            return false;
        }
        return det(params.get("A1"), params.get("C1"), params.get("A2"), params.get("C2")) == 0
                && det(params.get("B1"), params.get("C1"), params.get("B2"), params.get("C2")) == 0
                && intersection1D(p1.getX(), p2.getX(), targetSegment.p1.getX(), targetSegment.p2.getX())
                && intersection1D(p1.getY(), p2.getY(), targetSegment.p1.getY(), targetSegment.p2.getY());
    }


    /*Utils methods*/
    private boolean isValidSegment() {
        return p1.distance(p2) > EPSILON;
    }

    private double det(final double a11, final double a12, final double a21, final double a22) {
        return a11 * a22 - a12 * a21;
    }

    private boolean between(final double coordStart,
                            final double coordEnd,
                            final double coordTarget) {
        return Math.min(coordStart, coordEnd) <= coordTarget + EPSILON
                && coordTarget <= Math.max(coordStart, coordEnd) + EPSILON;
    }

    private Map<String, Double> getParameters(final Segment2D targetSegment) {
        Map<String, Double> params = new HashMap<>();

        params.put("A1", p1.getY() - p2.getY());
        params.put("B1", p2.getX() - p1.getX());
        params.put("C1", -params.get("A1") * p1.getX() - params.get("B1") * p1.getY());
        params.put("A2", targetSegment.p1.getY() - targetSegment.p2.getY());
        params.put("B2", targetSegment.p2.getX() - targetSegment.p1.getX());
        params.put("C2", -params.get("A2") * targetSegment.p1.getX()
                - params.get("B2") * targetSegment.p1.getY());

        return params;
    }

    private boolean intersection1D(final double segment1p1coord,
                                   final double segment1p2coord,
                                   final double segment2p1coord,
                                   final double segment2p2coord) {
        double segment1p1coordCurrent = segment1p1coord;
        double segment1p2coordCurrent = segment1p2coord;
        double segment2p1coordCurrent = segment2p1coord;
        double segment2p2coordCurrent = segment2p2coord;

        if (segment1p1coord > segment1p2coord) {
            segment1p1coordCurrent = segment1p2coord;
            segment1p2coordCurrent = segment1p1coord;
        }
        if (segment2p1coord > segment2p2coord) {
            segment2p1coordCurrent = segment2p2coord;
            segment2p2coordCurrent = segment2p1coord;
        }

        return Math.max(segment1p1coordCurrent, segment2p1coordCurrent)
                <= Math.min(segment1p2coordCurrent, segment2p2coordCurrent);
    }

}
