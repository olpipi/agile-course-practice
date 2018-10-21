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
}
