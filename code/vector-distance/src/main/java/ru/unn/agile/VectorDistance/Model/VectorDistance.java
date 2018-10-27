package ru.unn.agile.vectordistance.model;

public final class VectorDistance {
    public static float computeL1(final FloatVector a, final FloatVector b) {
        float distance = 0.f;

        for (int i = 0; i < a.length(); ++i) {
            distance += Math.abs(a.get(i) - b.get(i));
        }

        return distance;
    }

    private VectorDistance() { /* none */ }
}
