package ru.unn.agile.vectordistance.model;

import java.security.InvalidParameterException;
import java.util.Objects;

public final class VectorDistance {
    public static float computeL1(final FloatVector a, final FloatVector b) {
        Objects.requireNonNull(a, "Expected not null parameter a");
        Objects.requireNonNull(b, "Expected not null parameter b");
        if (a.length() != b.length()) {
            throw new InvalidParameterException(
                "Expected vectors of same length");
        }

        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.abs(a.get(i) - b.get(i));
        }

        return distance;
    }

    public static float computeL2(final FloatVector a, final FloatVector b) {
        return 0;
    }

    private VectorDistance() { /* none */ }
}
