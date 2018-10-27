package ru.unn.agile.vectordistance.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class VectorDistanceTest {
    @Test
    public void canComputeL1Distance() {
        FloatVector a = new FloatVector(new float[]{1.0f, 2.0f, 3.0f});
        FloatVector b = new FloatVector(new float[]{4.0f, 5.0f, 6.0f});

        float result = VectorDistance.computeL1(a, b);

        assertEquals(9.0f, result, 1e-14);
    }
}
