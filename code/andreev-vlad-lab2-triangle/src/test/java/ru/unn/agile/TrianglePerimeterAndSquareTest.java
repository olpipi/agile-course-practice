package ru.unn.agile;

import org.junit.Test;
import ru.unn.agile.primitives.Point;

import static org.junit.Assert.assertEquals;

public class TrianglePerimeterAndSquareTest {
    private final double delta = 0.001;

    @Test
    public void getPerimeterFromTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 0.0);
        Point point3 = new Point(3.0, 4.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(12, triangle.getPerimeter(), delta);
    }

    @Test
    public void getPerimeterFromRectangularTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(5.0, 0.0);
        Point point3 = new Point(5.0, 12.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(30, triangle.getPerimeter(), delta);
    }


    @Test
    public void getSquareFromTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(3.0, 0.0);
        Point point3 = new Point(3.0, 4.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(6, triangle.getSquare(), delta);
    }

    @Test
    public void getSquareFromRectangularTriangle() {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(8.0, 0.0);
        Point point3 = new Point(8.0, 15.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(60, triangle.getSquare(), delta);
    }

    @Test
    public void getSquareFromRectangularTriangleWithAIsHypotenuse() {
        Point point1 = new Point(4.0, 3.0);
        Point point2 = new Point(0.0, 0.0);
        Point point3 = new Point(4.0, 0.0);

        Triangle triangle = new Triangle(point1, point2, point3);

        assertEquals(6, triangle.getSquare(), delta);
    }
}
