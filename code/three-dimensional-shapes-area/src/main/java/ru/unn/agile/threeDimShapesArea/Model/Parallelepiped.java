package ru.unn.agile.threeDimShapesArea.Model;

/**
 * Created by Maria Pronina.
 */
public class Parallelepiped implements Shape {
    private final double a;
    private final double b;
    private final double c;

    public Parallelepiped(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        return 2 * (a * b + b * c + a * c);
    }
}
