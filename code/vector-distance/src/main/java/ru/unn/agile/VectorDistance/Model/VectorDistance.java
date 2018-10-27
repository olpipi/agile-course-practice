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
            ensureIsFinite(distance);
        }

        return distance;
    }

    public static float computeL2(final FloatVector a, final FloatVector b) {
        ensureNotNullArgs(a, b);
        ensureSameLength(a, b);

        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.pow(a.get(i) - b.get(i), 2);
            ensureIsFinite(distance);
        }

        return (float) Math.sqrt(distance);
    }

    public static float computeL3(final FloatVector a, final FloatVector b) {
        ensureNotNullArgs(a, b);
        ensureSameLength(a, b);

        final double l3Power = 3.0;
        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.pow(Math.abs(a.get(i) - b.get(i)), l3Power);
            ensureIsFinite(distance);
        }

        return (float) Math.pow(distance, 1.0 / l3Power);
    }

    public static float computeL4(final FloatVector a, final FloatVector b) {
        ensureNotNullArgs(a, b);
        ensureSameLength(a, b);

        final double l4Power = 4.0;
        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.pow(a.get(i) - b.get(i), l4Power);
            ensureIsFinite(distance);
        }

        return (float) Math.pow(distance, 1.0 / l4Power);
    }

    public static float computeLinf(final FloatVector a, final FloatVector b) {
        ensureNotNullArgs(a, b);
        ensureSameLength(a, b);

        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            float currentDistance = Math.abs(a.get(i) - b.get(i));
            ensureIsFinite(currentDistance);
            if (distance < currentDistance) {
                distance = currentDistance;
            }
        }

        return distance;
    }

    private VectorDistance() { /* none */ }

    private static void ensureIsFinite(final float x) {
        if (!Float.isFinite(x)) {
            throw new FloatingOverflowException("Floating overflow");
        }
    }

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
