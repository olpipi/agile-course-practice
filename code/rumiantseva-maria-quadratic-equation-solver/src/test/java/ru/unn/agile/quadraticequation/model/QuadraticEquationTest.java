package ru.unn.agile.quadraticequation.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuadraticEquationTest {
    @Test
    public void canGetQuadraticCoefficient() {
        QuadraticEquation func = new QuadraticEquation(5.1, 6.1, 7.1);

        double a = func.getA();

        assertEquals(5.1, a, QuadraticEquation.EPSILON);
    }

    @Test
    public void canGetLinearCoefficient() {
        QuadraticEquation func = new QuadraticEquation(5.1, 6.1, 7.1);

        double b = func.getB();

        assertEquals(6.1, b, QuadraticEquation.EPSILON);
    }

    @Test
    public void canGetFreeTerm() {
        QuadraticEquation func = new QuadraticEquation(5.1, 6.1, 7.1);

        double c = func.getC();

        assertEquals(7.1, c, QuadraticEquation.EPSILON);
    }

    @Test (expected = IllegalArgumentException.class)
    public void canNotCreateQuadraticEquationWithZeroACoeff() {
        QuadraticEquation func = new QuadraticEquation(0.0, 6.1, 7.1);
    }

    @Test (expected = QuadraticEquationSolverException.class)
    public void checkIfNoRealRoots() {
        QuadraticEquation func = new QuadraticEquation(1.1, 2.1, 3.1);

        func.solve();
    }

    @Test
    public void checkIfOneRoot() {
        QuadraticEquation func = new QuadraticEquation(1.0, -4.0, 4.0);
        double expectedRes = 2.0;

        double[] roots = func.solve();

        assertEquals(((roots[0] == roots[1]) && (roots[0] == expectedRes)), true);
    }

    @Test
    public void checkTwoRoots() {
        QuadraticEquation func = new QuadraticEquation(1.0, 2.0, -48.0);

        double[] roots = func.solve();

        assertEquals(-8.0, roots[0], QuadraticEquation.EPSILON);
        assertEquals(6.0, roots[1], QuadraticEquation.EPSILON);
    }

    @Test
    public void checkRootsSequence() {
        QuadraticEquation func = new QuadraticEquation(-1.0, -2.0, 15.0);

        double[] roots = func.solve();

        assertEquals(-5.0, roots[0], QuadraticEquation.EPSILON);
        assertEquals(3.0, roots[1], QuadraticEquation.EPSILON);
    }
}
