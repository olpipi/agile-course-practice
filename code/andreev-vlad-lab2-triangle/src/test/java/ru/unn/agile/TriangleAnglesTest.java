package ru.unn.agile;

import org.junit.Test;
import ru.unn.agile.primitives.Point;

import static org.junit.Assert.assertEquals;

public class TriangleAnglesTest {
    private final double delta = 0.001;

    @Test
    public void getAngleBetweenABFromRectangularTriangleTwoCathetus() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(4.0, 0.0);
        Point point3 = new Point(4.0, 3.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(1.57, triangle.getAngleAB(), delta);
    }

    @Test
    public void getAngleBetweenABFromRectangularTriangle() {
        Point point1 = new Point(0.0, 4.0);
        Point point2 = new Point(0.0, 0.0);
        Point point3 = new Point(3.0, 4.0);
        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(0.643, triangle.getAngleAB(), delta);
    }

    @Test
    public void getAngleBetweenABFromIsoscelesTriangleApex() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 4.0);
        Point point3 = new Point(6.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(1.287, triangle.getAngleAB(), delta);
    }

    @Test
    public void getAngleBetweenABFromIsoscelesTriangleFooting() {
        Point point1 = new Point(3.0, 4.0);
        Point point2 = new Point(0.0, 0.0);
        Point point3 = new Point(6.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(0.927, triangle.getAngleAB(), delta);
    }

    @Test
    public void getAngleBetweenABFromTriangle() {
        Point point1 = new Point(3.0, 4.0);
        Point point2 = new Point(1.0, -1.0);
        Point point3 = new Point(-4.0, -3.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(2.331, triangle.getAngleAB(), delta);
    }

    @Test
    public void getAngleBetweenBCFromTriangle() {
        Point point1 = new Point(-4.0, -3.0);
        Point point2 = new Point(3.0, 4.0);
        Point point3 = new Point(1.0, -1.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(2.331, triangle.getAngleBC(), delta);
    }

    @Test
    public void getAngleBetweenCAFromTriangle() {
        Point point1 = new Point(1.0, -1.0);
        Point point2 = new Point(-4.0, -3.0);
        Point point3 = new Point(3.0, 4.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(2.331, triangle.getAngleCA(), delta);
    }

}
