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
}
