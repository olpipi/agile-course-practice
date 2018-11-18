package ru.unn.agile.polynomial.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PolynomialTest {
    @Test
    public void checkInit() {
        double[] result = {1.0, -2.0, 3.0, -4.0};

        Polynomial p = new Polynomial(result);

        assertArrayEquals(result, p.getCoeffs(), Polynomial.DELTA);
        assertEquals(3, p.getDegree());
    }

    @Test
    public void checkInitWithFirstZero() {
        double[] toInit = {0.0, 0.0, 3.0};
        double[] result = {3.0};

        Polynomial p = new Polynomial(toInit);

        assertArrayEquals(result, p.getCoeffs(), Polynomial.DELTA);
        assertEquals(0, p.getDegree());
    }

    @Test
    public void checkInitWithZero() {
        double[] toInit = {1.0, 0.0, 3.0};
        double[] result = {1.0, 0.0, 3.0};

        Polynomial p = new Polynomial(toInit);

        assertArrayEquals(result, p.getCoeffs(), Polynomial.DELTA);
        assertEquals(2, p.getDegree());
    }

    @Test
    public void checkInitWithOnlyZero() {
        double[] toInit = {0.0};

        Polynomial p = new Polynomial(toInit);

        assertArrayEquals(null, p.getCoeffs(), Polynomial.DELTA);
        assertEquals(-1, p.getDegree());
    }
}
