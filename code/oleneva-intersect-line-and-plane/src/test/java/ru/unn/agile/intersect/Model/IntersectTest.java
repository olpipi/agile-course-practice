package ru.unn.agile.intersect.Model;

import org.junit.Test;

import ru.unn.agile.intersect.model.LineIntersectPlane;
import ru.unn.agile.intersect.model.objects.*;

import static org.junit.Assert.*;

public class IntersectTest {
    private double delta = 0.0000001;

    @Test
    public void canGetPointX() {
        Point pointA = new Point(1, 2, 3);
        assertEquals(1, pointA.getX(), delta);
    }

    @Test
    public void canGetPointY() {
        Point pointA = new Point(1, 2, 3);
        assertEquals(2, pointA.getY(), delta);
    }

    @Test
    public void canGetPointZ() {
        Point pointA = new Point(1, 2, 3);
        assertEquals(3, pointA.getZ(), delta);
    }

    @Test
    public void canGetLineX() {
        Point pointX = new Point(1, 2, 3);
        Point pointY = new Point(1, 2, 15);

        Line lineL = new Line(pointX, pointY);

        assertEquals(pointX.getX(), lineL.getX().getX(), delta);
        assertEquals(pointX.getY(), lineL.getX().getY(), delta);
        assertEquals(pointX.getZ(), lineL.getX().getZ(), delta);
    }

    @Test
    public void canGetLineY() {
        Point pointX = new Point(1, 2, 3);
        Point pointY = new Point(1, 2, 15);

        Line lineL = new Line(pointX, pointY);

        assertEquals(pointY.getX(), lineL.getY().getX(), delta);
        assertEquals(pointY.getY(), lineL.getY().getY(), delta);
        assertEquals(pointY.getZ(), lineL.getY().getZ(), delta);
    }

    @Test
    public void canGetPlaneA() {
        Point pointA = new Point(15, 4, 21);
        Point pointB = new Point(5, -5, 6);
        Point pointC = new Point(4, 2, -15);

        Plane planeP = new Plane(pointA, pointB, pointC);

        assertEquals(pointA.getX(), planeP.getA().getX(), delta);
        assertEquals(pointA.getY(), planeP.getA().getY(), delta);
        assertEquals(pointA.getZ(), planeP.getA().getZ(), delta);
    }

    @Test
    public void canGetPlaneB() {
        Point pointA = new Point(54, 5, 1);
        Point pointB = new Point(23, 2, 9);
        Point pointC = new Point(-45, 2, 15);

        Plane planeP = new Plane(pointA, pointB, pointC);

        assertEquals(pointB.getX(), planeP.getB().getX(), delta);
        assertEquals(pointB.getY(), planeP.getB().getY(), delta);
        assertEquals(pointB.getZ(), planeP.getB().getZ(), delta);
    }

    @Test
    public void canGetPlaneC() {
        Point pointA = new Point(1, 7, 0);
        Point pointB = new Point(15, 2, 9);
        Point pointC = new Point(2, 3, 15);

        Plane planeP = new Plane(pointA, pointB, pointC);

        assertEquals(pointC.getX(), planeP.getC().getX(), delta);
        assertEquals(pointC.getY(), planeP.getC().getY(), delta);
        assertEquals(pointC.getZ(), planeP.getC().getZ(), delta);
    }

    @Test
    public void canCreatVector() {
        Point pointA = new Point(1, 0, 0);
        Point pointB = new Point(0, 2, 0);

        Point vectorV = pointA.createVector(pointB);

        assertEquals(vectorV.getX(), 1, delta);
        assertEquals(vectorV.getY(), -2, delta);
        assertEquals(vectorV.getZ(), 0, delta);
    }

    @Test
    public void canVectorProduct() {
        Point pointA = new Point(1, 2, 1);
        Point pointB = new Point(2, 0, 1);

        Point vectorProduct = pointA.vectorProduct(pointB);

        assertEquals(vectorProduct.getX(), 2, delta);
        assertEquals(vectorProduct.getY(), 1, delta);
        assertEquals(vectorProduct.getZ(), -4, delta);

    }

    @Test
    public void canScalarProduct() {
        Point pointA = new Point(1, 5, 26);
        Point pointB = new Point(2, -1, 0);

        double scalarProduct = pointA.scalarProduct(pointB);

        assertEquals(scalarProduct, -3, delta);
    }

    @Test
    public void canNormalizeVector() {
        Point pointB = new Point(3, 4, 0);

        Point normalPointB = pointB.normalizePoint();

        assertEquals(normalPointB.getX(), 0.6, delta);
        assertEquals(normalPointB.getY(), 0.8, delta);
        assertEquals(normalPointB.getZ(), 0, delta);
    }

    @Test
    public void canCountNormalToPlane() {
        Point pointA = new Point(1, 1, 1);
        Point pointB = new Point(0, 2, 0);
        Point pointC = new Point(0, 1, 0);

        Plane planeP = new Plane(pointA, pointB, pointC);

        Point normalN = planeP.countNormalToPlane();

        assertEquals(normalN.getX(), -0.707106781188095, delta);
        assertEquals(normalN.getY(), 0, delta);
        assertEquals(normalN.getZ(), 0.707106781188095, delta);

    }

    @Test
    public void canCountToNormalDistance() {
        Point pointA = new Point(1, 0, 1);
        Point pointB = new Point(34, 2, 0);
        Point pointC = new Point(50, -31, 0);

        Point pointX = new Point(1, -1, 0);
        Point pointY = new Point(1, 2, 89);

        Line lineL = new Line(pointX, pointY);

        Plane planeP = new Plane(pointA, pointB, pointC);

        double distance = planeP.countToNormalDistance(lineL);

        assertEquals(distance, -1.0137306107981, delta);
    }

    @Test
    public void canLineIntersectPlaneWithCommonPoint() {
        //Arrange
        Point pointA = new Point(1, 0, 1);
        Point pointB = new Point(86, 2, 0);
        Point pointC = new Point(0, 1, 0);

        Point pointX = new Point(11, 35, 1);
        Point pointY = new Point(-91, 2, 15);

        Line lineL = new Line(pointX, pointY);

        Plane planeP = new Plane(pointA, pointB, pointC);

        //Assert
        LineIntersectPlane check = new LineIntersectPlane(planeP, lineL);

        //Act
        assertEquals(true, check.checkIntersection());
    }

    @Test
    public void canLineIntersectPlaneParallel() {
        //Arrange
        Point pointA = new Point(1, 94, 0);
        Point pointB = new Point(56, 2, 0);
        Point pointC = new Point(10, 1, 0);

        Point pointX = new Point(1, -87, 15);
        Point pointY = new Point(2, 2, 15);

        Line lineL = new Line(pointX, pointY);

        Plane planeP = new Plane(pointA, pointB, pointC);

        //Assert
        LineIntersectPlane check = new LineIntersectPlane(planeP, lineL);

        //Act
        assertEquals(false, check.checkIntersection());
    }

    @Test
    public void canLineIntersectPlaneWhenLineBelongPlane() {
        //Arrange
        Point pointA = new Point(1, 9, 0);
        Point pointB = new Point(96, 2, 0);
        Point pointC = new Point(4, 73, 0);

        Point pointX = new Point(1, -87, 0);
        Point pointY = new Point(2, 2, 0);

        Line lineL = new Line(pointX, pointY);

        Plane planeP = new Plane(pointA, pointB, pointC);

        //Assert
        LineIntersectPlane check = new LineIntersectPlane(planeP, lineL);

        //Act
        assertEquals(true, check.checkIntersection());
    }

    @Test
    public void canLineIntersectPlaneWithRandomPoint() {
        Point pointA = new Point(1, 0, 1);
        Point pointB = new Point(0, 2, 0);
        Point pointC = new Point(0, 1, 0);

        Point pointX = new Point(1, -1, 0);
        Point pointY = new Point(1, 2, 15);

        Line lineL = new Line(pointX, pointY);

        Plane planeP = new Plane(pointA, pointB, pointC);

        LineIntersectPlane check = new LineIntersectPlane(planeP, lineL);

        assertEquals(true, check.checkIntersection());
    }
}

