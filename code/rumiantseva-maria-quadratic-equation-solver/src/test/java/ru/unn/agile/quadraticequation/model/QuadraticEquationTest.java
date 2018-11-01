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
}
