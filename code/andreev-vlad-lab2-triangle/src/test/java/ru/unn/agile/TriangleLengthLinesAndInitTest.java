package ru.unn.agile;

import org.junit.Test;
import ru.unn.agile.primitives.Point;

import static org.junit.Assert.*;

public class TriangleLengthLinesAndInitTest {
    private final double delta = 0.001;

    @Test
    public void getAFromSimpleTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(1.0, 0.0);
        Point point3 = new Point(0.0, 1.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(1.0, triangle.getLengthA(), delta);
    }

    @Test
    public void getAFromRectangularTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 4.0);
        Point point3 = new Point(0.0, 1.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test
    public void getAFromTriangleWithNegativePoint() {
        Point point1 = new Point(-1.0, 0.0);
        Point point2 = new Point(2.0, 4.0);
        Point point3 = new Point(0.0, 1.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test
    public void getAFromIsoscelesTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 4.0);
        Point point3 = new Point(6.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(0.0, 0.0);
        Point point3 = new Point(6.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidTriangleThreePointsOnOneLine() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(1.0, 1.0);
        Point point3 = new Point(2.0, 2.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidTriangleThreePointsOnOneLineWithZero() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(1.0, 0.0);
        Point point3 = new Point(2.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidTriangleWithNullPoint() {
        Point point1 = null;
        Point point2 = new Point(1.0, 0.0);
        Point point3 = new Point(2.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test
    public void getBFromRectangularTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 0.0);
        Point point3 = new Point(0.0, 4.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthB(), delta);
    }

    @Test
    public void getCFromRectangularTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 0.0);
        Point point3 = new Point(3.0, 4.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(5.0, triangle.getLengthC(), delta);
    }



}
