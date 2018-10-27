package ru.unn.agile.vectordistance.model;

import java.security.InvalidParameterException;
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

    @Test(expected = InvalidParameterException.class)
    public void canNotComputeL1DistanceOfDifferentLengthVectors()
            throws InvalidParameterException {
        FloatVector a = new FloatVector(new float[]{1.0f});
        FloatVector b = new FloatVector(new float[]{4.0f, 5.0f});

        VectorDistance.computeL1(a, b);
    }

    @Test(expected = NullPointerException.class)
    public void canNotComputeL1DistanceOfNullVector()
            throws NullPointerException {
        VectorDistance.computeL1(null, null);
    }

    @Test
    public void canComputeL2Distance() {
        FloatVector a = new FloatVector(new float[]{1.0f, 2.0f, 3.0f, 4.0f});
        FloatVector b = new FloatVector(new float[]{4.0f, 5.0f, 6.0f, 7.0f});

        float result = VectorDistance.computeL2(a, b);

        assertEquals(6.0f, result, 1e-14);
    }

    @Test
    public void canComputeL2DistanceWithNegatives() {
        FloatVector a = new FloatVector(new float[]{-9.0f, 8.0f, -7.0f, 6.0f});
        FloatVector b = new FloatVector(new float[]{1.0f, -2.0f, 3.0f, -4.0f});

        float result = VectorDistance.computeL2(a, b);

        assertEquals(20.0f, result, 1e-14);
    }

    @Test(expected = NullPointerException.class)
    public void canNotComputeL2DistanceOfNullVector()
            throws NullPointerException {
        VectorDistance.computeL2(null, null);
    }
    @Test(expected = InvalidParameterException.class)
    public void canNotComputeL2DistanceOfDifferentLengthVectors()
            throws InvalidParameterException {
        FloatVector a = new FloatVector(new float[]{1.0f});
        FloatVector b = new FloatVector(new float[]{4.0f, 5.0f});

        VectorDistance.computeL2(a, b);
    }

    @Test
    public void canComputeL3Distance() {
        FloatVector a = new FloatVector(
            new float[]{-9.0f, 8.0f, -7.0f, 6.0f, -5.0f, 4.0f, -3.0f, 2.0f});
        FloatVector b = new FloatVector(
            new float[]{1.0f, -2.0f, 3.0f, -4.0f, 5.0f, -6.0f, 7.0f, -8.0f});

        float result = VectorDistance.computeL3(a, b);

        assertEquals(20.0f, result, 1e-14);
    }
}
