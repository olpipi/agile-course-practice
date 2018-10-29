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

    @Test
    public void canGetUnitParallelepipedArea() {
        Shape parallelepiped = new Parallelepiped(1, 1, 1);
        double area = parallelepiped.getArea();
        assert area == 6;
    }

    @Test
    public void canGetParallelepipedArea() {
        Shape parallelepiped = new Parallelepiped(1, 3, 5);
        double area = parallelepiped.getArea();
        assert area == 46;
    }


    @Test
    public void canGetUnitCylinderArea() {
        Shape cylinder = new Cylinder(1, 1);
        double area = cylinder.getArea();
        assert area == 4 * Math.PI;
    }

    @Test
    public void canGetCylinderArea() {
        Shape cylinder = new Cylinder(3, 5);
        double area = cylinder.getArea();
        assert area == 2 * Math.PI * 3 * 8;
    }

    @Test
    public void canGetUnitSquarePyramidArea() {
        Shape squarePyramid = new SquarePyramid(1, 1);
        double area = squarePyramid.getArea();
        assert area == 1 + 2 * Math.sqrt(0.75);
    }

    @Test
    public void canGetSquarePyramidArea() {
        Shape squarePyramid = new SquarePyramid(2, 5);
        double area = squarePyramid.getArea();
        double expectedArea = 4 + 2 * 2 * Math.sqrt(5 * 5 - 2 * 2 / 4);
        assert Math.abs(area - expectedArea) < 0.00001;
    }


}
