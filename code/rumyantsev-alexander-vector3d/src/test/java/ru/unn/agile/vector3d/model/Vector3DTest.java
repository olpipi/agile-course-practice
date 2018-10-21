package ru.unn.agile.vector3d.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class Vector3DTest {
    @Test
    public void canGetXPositiveDouble() {
        Vector3D v = new Vector3D(1.0, 2, 3);

        assertEquals(1.0, v.getX(), Vector3D.EPSILON);
    }

    @Test
    public void canGetXNegativeDouble() {
        Vector3D v = new Vector3D(-1.3, 0, 0);

        assertEquals(-1.3, v.getX(), Vector3D.EPSILON);
    }

    @Test
    public void canGetYPositiveDouble() {
        Vector3D v = new Vector3D(0, 4.5, 1);

        assertEquals(4.5, v.getY(), Vector3D.EPSILON);
    }

    @Test
    public void canGetYNegativeDouble() {
        Vector3D v = new Vector3D(1, -10, 0);

        assertEquals(-10.0, v.getY(), Vector3D.EPSILON);
    }

    @Test
    public void canGetZPositiveDouble() {
        Vector3D v = new Vector3D(0, 0, 100.3);

        assertEquals(100.3, v.getZ(), Vector3D.EPSILON);
    }

    @Test
    public void canGetZNegativeDouble() {
        Vector3D v = new Vector3D(2, 2, -1337.228);

        assertEquals(-1337.228, v.getZ(), Vector3D.EPSILON);
    }

    @Test
    public void canSetXPositiveDouble() {
        Vector3D v = new Vector3D(0,0, 0);

        v.setX(0.5);

        assertEquals(0.5, v.getX(), Vector3D.EPSILON);
    }

    @Test
    public void canSetXNegativeDouble() {
        Vector3D v = new Vector3D(0,0, 0);

        v.setX(-3.3);

        assertEquals(-3.3, v.getX(), Vector3D.EPSILON);
    }

    @Test
    public void canSetYPositiveDouble() {
        Vector3D v = new Vector3D(0,0, 0);

        v.setY(0.144);

        assertEquals(0.144, v.getY(), Vector3D.EPSILON);
    }

    @Test
    public void canSetYNegativeDouble() {
        Vector3D v = new Vector3D(0,0, 0);

        v.setY(-3.1415);

        assertEquals(-3.1415, v.getY(), Vector3D.EPSILON);
    }

    @Test
    public void canSetZPositiveDouble() {
        Vector3D v = new Vector3D(0,0, 0);

        v.setZ(43.5);

        assertEquals(43.5, v.getZ(), Vector3D.EPSILON);
    }

    @Test
    public void canSetZNegativeDouble() {
        Vector3D v = new Vector3D(0,0, 0);

        v.setZ(-25.4);

        assertEquals(-25.4, v.getZ(), Vector3D.EPSILON);
    }

    @Test
    public void canCompareVectors() {
        Vector3D v1 = new Vector3D(1.1, 2.2, 3.3);
        Vector3D v2 = new Vector3D(1.1, 2.2, 3.3);

        assertEquals(v2, v1);
    }

    @Test
    public void canCompareToItself() {
        Vector3D v = new Vector3D(7, 32, 5);

        assertEquals(v, v);
    }

    @Test
    public void cantCompareToNonVector() {
        Vector3D v = new Vector3D(4.3, 45.1, -5.1);

        assertNotEquals("Vector3D", v);
    }

    @Test
    public void compareVectorsDifferentX() {
        Vector3D v1 = new Vector3D(7.4, -4.5, 1.2);
        Vector3D v2 = new Vector3D(10.2, -4.5, 1.2);

        assertNotEquals(v2, v1);
    }

    @Test
    public void compareVectorsDifferentY() {
        Vector3D v1 = new Vector3D(1, 3, 1);
        Vector3D v2 = new Vector3D(1, -3, 1);

        assertNotEquals(v2, v1);
    }

    @Test
    public void compareVectorsDifferentZ() {
        Vector3D v1 = new Vector3D(0, 0, -1);
        Vector3D v2 = new Vector3D(0, 0, -2);

        assertNotEquals(v2, v1);
    }

    @Test
    public void compareVectorsDifferentXLessEps() {
        Vector3D v1 = new Vector3D(3, 3, 3);
        Vector3D v2 = new Vector3D(3 + Vector3D.EPSILON * 10.0, 3, 3);

        assertNotEquals(v2, v1);
    }

    @Test
    public void compareVectorsDifferentYLessEps() {
        Vector3D v1 = new Vector3D(-1.2, 0.0, 6.7);
        Vector3D v2 = new Vector3D(-1.2, -Vector3D.EPSILON * 2, 6.7);

        assertNotEquals(v2, v1);
    }

    @Test
    public void compareVectorsDifferentZLessEps() {
        Vector3D v1 = new Vector3D(0, 0, 1000000);
        Vector3D v2 = new Vector3D(0, 0, 1000000 -Vector3D.EPSILON * 1.1);

        assertNotEquals(v2, v1);
    }
}
