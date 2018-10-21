package ru.unn.agile.vector3d.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class Vector3DTest {
    @Test
    public void canGetX() {
        Vector3D v = new Vector3D(1, 2, 3);

        assertEquals(1, v.getX(), Vector3D.EPSILON);
    }
}
