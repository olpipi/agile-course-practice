package ru.unn.agile.threeDimShapesArea.Model;


import org.junit.Test;

public class ShapesAreaTest {
    @Test
    public void canGetCubeArea() {
        Shape cube = new Cube(1);
        double area = cube.getArea();
        assert area == 6;
    }

    @Test
    public void canGetCubeAreaWithTwoSide() {
        Shape cube = new Cube(2);
        double area = cube.getArea();
        assert area == 24;
    }

    @Test
    public void canGetSphereArea() {
        Shape sphere = new Sphere(1);
        double area = sphere.getArea();
        assert area == 4 * Math.PI;
    }

    @Test
    public void canGetSphereWithRadiusTwoArea() {
        Shape sphere = new Sphere(2);
        double area = sphere.getArea();
        assert area == 16 * Math.PI;
    }


}
