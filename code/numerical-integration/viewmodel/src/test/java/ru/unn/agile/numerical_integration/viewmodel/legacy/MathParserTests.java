package ru.unn.agile.numerical_integration.ViewModel.legacy;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class MathParserTests {
    private static final double DOUBLE_PRECISION = 1e-15;

    @Test
    public void canComputeNumber() {
        MathParser parser = new MathParser("10");

        boolean status = parser.eval(0);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(10.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeNegativeNumber() {
        MathParser parser = new MathParser("-10");

        boolean status = parser.eval(0);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(-10.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeNothing() {
        MathParser parser = new MathParser("");

        boolean status = parser.eval(0);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(0.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeVariable() {
        MathParser parser = new MathParser("x");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(10.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeNegatedVariable() {
        MathParser parser = new MathParser("-x");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(-10.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeWhitespaces() {
        MathParser parser = new MathParser("   ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(0.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeNumberWithinWhitespaces() {
        MathParser parser = new MathParser("   5   ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(5.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeSum() {
        MathParser parser = new MathParser(" 5 + 2  ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(7.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeSumOfNumbers() {
        MathParser parser = new MathParser(" 5 + 2  ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(7.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeSumOfVariables() {
        MathParser parser = new MathParser(" x + x  ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(20.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeProduct() {
        MathParser parser = new MathParser(" 5 * x  ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(50.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeDifference() {
        MathParser parser = new MathParser(" 5 - x  ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(-5.0, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeRatio() {
        MathParser parser = new MathParser(" -5 / x  ");

        boolean status = parser.eval(10);
        double result = parser.getResult();

        assertTrue(status);
        assertEquals(-0.5, result, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeInRightOrder() {
        MathParser parser1 = new MathParser(" 2 + 2 * 2  ");
        MathParser parser2 = new MathParser(" 2 * 2 + 2  ");

        parser1.eval(10);
        double result1 = parser1.getResult();

        parser2.eval(10);
        double result2 = parser2.getResult();

        assertEquals(result1, result2, DOUBLE_PRECISION);
    }

    @Test
    public void canComputeTwice() {
        MathParser parser = new MathParser(" 2 * x - 7  ");
        parser.eval(10);

        parser.eval(20);
        double result = parser.getResult();

        assertEquals(33.0, result, DOUBLE_PRECISION);
    }
}
