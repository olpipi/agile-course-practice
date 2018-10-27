package ru.unn.agile.segments2d.model;

import java.util.Objects;

public class Segments2D {

    public static final double EPSILON = 0.000001;

    private double x1, y1, x2, y2;

    public Segments2D(final double x1, final double y1, final double x2, final double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

}
