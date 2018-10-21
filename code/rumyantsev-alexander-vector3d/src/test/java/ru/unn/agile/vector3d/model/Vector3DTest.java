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
}
