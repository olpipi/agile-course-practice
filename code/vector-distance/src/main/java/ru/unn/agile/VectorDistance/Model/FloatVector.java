package ru.unn.agile.vectordistance.model;

public class FloatVector {
    private float[] elements;

    public FloatVector(final float[] elements) {
        this.elements = elements;
    }

    public float get(final int i) {
        return this.elements[i];
    }

    public int length() {
        return this.elements.length;
    }
}
