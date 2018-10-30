package ru.unn.agile.segment2d.model;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class Segment2DTest {

    private static final double EPSILON = Segment2D.EPSILON;

    @Test
    public void canCreateSegment2D_withCoords() {
        Segment2D segment = new Segment2D(0.0, 0.0, 1.0, 1.0);

        assertNotNull(segment);
    }

    @Test
    public void canCreateSegment2D_withPoints() {
        Segment2D segment = new Segment2D(new Point2D.Double(0.0, 0.0), new Point2D.Double(1.0, 1.0));

        assertNotNull(segment);
    }

    @Test
    public void areEqualCreateSegment2D() {
        Segment2D seg1 = new Segment2D(new Point2D.Double(0.0, 0.0), new Point2D.Double(1.0, 1.0));
        Segment2D seg2 = new Segment2D(0.0, 0.0, 1.0, 1.0);

        assertEquals(seg1, seg2);
    }

    @Test
    public void canGetSegment2D_P1() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D segment = new Segment2D(p1, p2);

        assertEquals(p1, segment.getP1());
    }

    @Test
    public void canSetSegment2D_P1() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Point2D p3 = new Point2D.Double(3.0, 3.0);
        Segment2D segment = new Segment2D(p1, p2);

        segment.setP1(p3);

        assertEquals(p3, segment.getP1());
    }

    @Test
    public void canGetSegment2D_P2() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D segment = new Segment2D(p1, p2);

        assertEquals(p2, segment.getP2());
    }

    @Test
    public void canSetSegment2D_P2() {
        Point2D p1 = new Point2D.Double(11.0, 11.0);
        Point2D p2 = new Point2D.Double(22.0, 22.0);
        Point2D p3 = new Point2D.Double(33.0, 33.0);
        Segment2D segment = new Segment2D(p1, p2);

        segment.setP2(p3);

        assertEquals(p3, segment.getP2());
    }

    @Test
    public void areEqualSegment2D_theSame() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D seg1 = new Segment2D(p1, p2);
        Segment2D seg2 = new Segment2D(p1, p2);

        assertEquals(seg1, seg2);
    }

    @Test
    public void areEqualSegment2D_itself() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D seg = new Segment2D(p1, p2);

        assertEquals(seg, seg);
    }

    @Test
    public void areNotEqualSegment2D_DifferentP1() {
        Point2D p1 = new Point2D.Double(4.0, 4.0);
        Point2D p2 = new Point2D.Double(5.0, 5.0);
        Point2D p3 = new Point2D.Double(6.0, 6.0);
        Segment2D seg1 = new Segment2D(p1, p2);
        Segment2D seg2 = new Segment2D(p3, p2);

        assertNotEquals(seg1, seg2);
    }

    @Test
    public void areNotEqualSegment2D_DifferentP2() {
        Point2D p1 = new Point2D.Double(7.0, 7.0);
        Point2D p2 = new Point2D.Double(8.0, 8.0);
        Point2D p3 = new Point2D.Double(9.0, 9.0);
        Segment2D seg1 = new Segment2D(p1, p2);
        Segment2D seg2 = new Segment2D(p1, p3);

        assertNotEquals(seg1, seg2);
    }

    @Test
    public void areNotEqualSegment2D_null() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D seg = new Segment2D(p1, p2);

        assertNotEquals(null, seg);
    }

    @Test
    public void areNotEqualSegment2D_object() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D seg = new Segment2D(p1, p2);

        assertNotEquals(new Object(), seg);
    }

    @Test
    public void areEqualHashCodeSegment2D_theSame() {
        Point2D p1 = new Point2D.Double(3.0, 3.0);
        Point2D p2 = new Point2D.Double(4.0, 4.0);
        Segment2D seg1 = new Segment2D(p1, p2);
        Segment2D seg2 = new Segment2D(p1, p2);

        assertEquals(seg1.hashCode(), seg2.hashCode());
    }

    @Test
    public void areEqualHashCodeSegment2D_itself() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D seg = new Segment2D(p1, p2);

        assertEquals(seg.hashCode(), seg.hashCode());
    }

    @Test
    public void canToStringSegment2D() {
        Point2D p1 = new Point2D.Double(1.0, 1.0);
        Point2D p2 = new Point2D.Double(2.0, 2.0);
        Segment2D seg = new Segment2D(p1, p2);

        assertEquals("Segment2D{p1=Point2D.Double[1.0, 1.0], p2=Point2D.Double[2.0, 2.0]}", seg.toString());
    }

}
