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

    @Test
    public void canGetUnitHexagonalPyramidArea() {
        Shape pyramid = new HexagonalPyramid(1, 1);
        double area = pyramid.getArea();
        double expectedArea = 3 * (Math.sqrt(0.75) + Math.sqrt(3) / 2);
        assert Math.abs(area - expectedArea) < 0.00001;
    }

    @Test
    public void canGetUnitTriangleArea() {
        Shape triangle = new Triangle(1, 1, 1);
        double area = triangle.getArea();
        double expectedArea = Math.sqrt(3) / 4;
        assert Math.abs(area - expectedArea) < 0.00001;
    }

    @Test
    public void canGetUnitHexagonArea() {
        Shape hexagon = new Hexagon(1);
        double area = hexagon.getArea();
        double expectedArea = 3 * Math.sqrt(3) / 2;
        assert Math.abs(area - expectedArea) < 0.00001;
    }

    @Test
    public void canGetTrianglePrismArea() {
        Shape prism = new TrianglePrism(new Triangle(1, 1, 1), 5);
        double area = prism.getArea();
        double expectedArea = Math.sqrt(3) / 2 + 3 * 5;
        assert Math.abs(area - expectedArea) < 0.00001;
    }

    @Test
    public void canGetCircleArea() {
        Shape circle = new Circle(4);
        double area = circle.getArea();
        double expectedArea = Math.PI * 16;
        assert Math.abs(area - expectedArea) < 0.00001;
    }

    @Test
    public void canGetConesArea() {
        Shape cones = new Cone(4, 5);
        double area = cones.getArea();
        double expectedArea = Math.PI * 20 + Math.PI * 16;
        assert Math.abs(area - expectedArea) < 0.00001;
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCircleWithNegativeRadius() {
        Shape shape = new Circle(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateConeWithNegativeParams() {
        Shape shape = new Cone(-1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCubeWithNegativeParams() {
        Shape shape = new Cube(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCylinderWithNegativeParams() {
        Shape shape = new Cylinder(-1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateHexagonWithNegativeParams() {
        Shape shape = new Hexagon(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateHexagonalPyramidWithNegativeParams() {
        Shape shape = new HexagonalPyramid(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateParallelepipedWithNegativeParams() {
        Shape shape = new Parallelepiped(1, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateSphereWithNegativeParams() {
        Shape shape = new Sphere(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateSquarePyramidWithNegativeParams() {
        Shape shape = new SquarePyramid(-3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateTrianglePrismWithNegativeParams() {
        Shape shape = new TrianglePrism(new Triangle(0,0,0), -1);
    }













}
