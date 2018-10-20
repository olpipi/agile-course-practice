package ru.unn.agile;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {
    private final double delta = 0.001;

    @Test
    public void get_a_from_00_10_11_triangle(){
        Point point1 = new Point(0.0,0.0);
        Point point2 = new Point(1.0,0.0);
        Point point3 = new Point(0.0,1.0);
        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(1.0, triangle.getLengthA(), delta);
    }

    @Test
    public void get_a_from_00_34_11_triangle(){
        Point point1 = new Point(0.0,0.0);
        Point point2 = new Point(3.0,4.0);
        Point point3 = new Point(0.0,1.0);
        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test
    public void get_a_from_minus10_24_11_triangle(){
        Point point1 = new Point(-1.0,0.0);
        Point point2 = new Point(2.0,4.0);
        Point point3 = new Point(0.0,1.0);
        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test
    public void get_a_from_00_34_60_triangle(){
        Point point1 = new Point(0.0,0.0);
        Point point2 = new Point(3.0,4.0);
        Point point3 = new Point(6.0,0.0);

        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_invalid_triangle(){
        Point point1 = new Point(0.0,0.0);
        Point point2 = new Point(0.0,0.0);
        Point point3 = new Point(6.0,0.0);

        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_invalid_triangle_three_points_on_one_line(){
        Point point1 = new Point(0.0,0.0);
        Point point2 = new Point(1.0,1.0);
        Point point3 = new Point(2.0,2.0);

        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_invalid_triangle_three_points_on_one_line_with_00(){
        Point point1 = new Point(0.0,0.0);
        Point point2 = new Point(1.0,0.0);
        Point point3 = new Point(2.0,0.0);

        Triangele triangle = new Triangele(point1,point2,point3);

        assertEquals(5.0, triangle.getLengthA(), delta);
    }
}
