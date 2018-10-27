package ru.unn.agile.vectordistance.model;

import java.security.InvalidParameterException;
import java.util.Objects;

public final class VectorDistance {
    public static float computeL1(final FloatVector a, final FloatVector b) {
        ensureNotNullArgs(a, b);
        ensureSameLength(a, b);

        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.abs(a.get(i) - b.get(i));
        }

        return distance;
    }

    public static float computeL2(final FloatVector a, final FloatVector b) {
        ensureNotNullArgs(a, b);
        ensureSameLength(a, b);

        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.pow(a.get(i) - b.get(i), 2);
        }

        return (float) Math.sqrt(distance);
    }

    private VectorDistance() { /* none */ }

    private static void ensureNotNullArgs(
            final FloatVector a, final FloatVector b) {
        Objects.requireNonNull(a, "Expected not null parameter a");
        Objects.requireNonNull(b, "Expected not null parameter b");
    }

    private static void ensureSameLength(
            final FloatVector a, final FloatVector b) {
        if (a.length() != b.length()) {
            throw new InvalidParameterException(
                "Expected vectors of same length");
        }
    }
}
