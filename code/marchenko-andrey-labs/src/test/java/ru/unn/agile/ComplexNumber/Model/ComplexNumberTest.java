package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {

    private static final double EPSILON = ComplexNumber.EPSILON;

    @Test
    public void canCreateComplexNumberWithInitialValues() {
        ComplexNumber number = new ComplexNumber(1.0, 1.0);

        assertNotNull(number);
    }

    @Test
    public void canGetInitialRealValue() {
        ComplexNumber number = new ComplexNumber(1.0, 2.0);

        assertEquals(1.0, number.getReal(), EPSILON);
    }

    @Test
    public void canSetInitialRealValue() {
        ComplexNumber number = new ComplexNumber(1.0, 2.0);

        number.setReal(2.35);

        assertEquals(2.35, number.getReal(), EPSILON);
    }

    @Test
    public void canGetInitialImaginaryValue() {
        ComplexNumber number = new ComplexNumber(1.0, 2.0);

        assertEquals(2.0, number.getImaginary(), EPSILON);
    }

    @Test
    public void canSetInitialImaginaryValue() {
        ComplexNumber number = new ComplexNumber(1.0, 2.0);

        number.setImaginary(2.35);

        assertEquals(2.35, number.getImaginary(), EPSILON);
    }

    @Test
    public void areEqualComplexNumbersEqual() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 2.0);

        assertEquals(z1, z2);
    }

    @Test
    public void areComplexNumbersWithDifferentRealValueNotEqual() {
        ComplexNumber z1 = new ComplexNumber(2.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 2.0);

        assertNotEquals(z1, z2);
    }

    @Test
    public void areComplexNumbersWithDifferentImaginaryValueNotEqual() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        assertNotEquals(z1, z2);
    }

    @Test
    public void canAddComplexNumbersWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        ComplexNumber z3 = z1.add(z2);

        assertEquals(new ComplexNumber(2.0, 3.0), z3);
    }

    @Test
    public void canAddComplexNumbersWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);
        ComplexNumber z2 = new ComplexNumber(-1.0, -1.0);

        ComplexNumber z3 = z1.add(z2);

        assertEquals(new ComplexNumber(-2.0, -3.0), z3);
    }

    @Test
    public void canAddComplexNumbersWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z3 = z1.add(z2);

        assertEquals(new ComplexNumber(0.0, 0.0), z3);
    }

    @Test
    public void canSubtractComplexNumbersWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        ComplexNumber z3 = z1.subtract(z2);

        assertEquals(new ComplexNumber(0.0, 1.0), z3);
    }

    @Test
    public void canSubtractComplexNumbersWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);
        ComplexNumber z2 = new ComplexNumber(-1.0, -1.0);

        ComplexNumber z3 = z1.subtract(z2);

        assertEquals(new ComplexNumber(0.0, -1.0), z3);
    }

    @Test
    public void canSubtractComplexNumbersWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z3 = z1.subtract(z2);

        assertEquals(new ComplexNumber(0.0, 0.0), z3);
    }

    @Test
    public void canMultiplyComplexNumbersWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        ComplexNumber z3 = z1.multiply(z2);

        assertEquals(new ComplexNumber(-1.0, 3.0), z3);
    }

    @Test
    public void canMultiplyComplexNumbersWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);
        ComplexNumber z2 = new ComplexNumber(-1.0, -1.0);

        ComplexNumber z3 = z1.multiply(z2);

        assertEquals(new ComplexNumber(-1.0, 3.0), z3);
    }

    @Test
    public void canMultiplyComplexNumbersWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z3 = z1.multiply(z2);

        assertEquals(new ComplexNumber(0.0, 0.0), z3);
    }

    @Test
    public void canConjugateComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);

        ComplexNumber z2 = z1.conjugate();

        assertEquals(new ComplexNumber(1.0, -2.0), z2);
    }

    @Test
    public void canConjugateComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);

        ComplexNumber z2 = z1.conjugate();

        assertEquals(new ComplexNumber(-1.0, 2.0), z2);
    }

    @Test
    public void canConjugateComplexNumberZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z2 = z1.conjugate();

        assertEquals(new ComplexNumber(0.0, 0.0), z2);
    }

    @Test
    public void canCalculateMagnitudeForComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(3.0, 4.0);

        double magnitude = z1.magnitude();

        assertEquals(5.0, magnitude, EPSILON);
    }

    @Test
    public void canCalculateMagnitudeForComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-3.0, -4.0);

        double magnitude = z1.magnitude();

        assertEquals(5.0, magnitude, EPSILON);
    }

    @Test
    public void canCalculateMagnitudeForComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        double magnitude = z1.magnitude();

        assertEquals(0.0, magnitude, EPSILON);
    }

    @Test(expected = ArithmeticException.class)
    public void canDivideComplexNumberByZero() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 0.0);

        z1.divide(z2);
    }

    @Test
    public void canDivideComplexNumbersWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(2.0, 4.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 2.0);

        ComplexNumber z3 = z1.divide(z2);

        assertEquals(new ComplexNumber(2.0, 0.0), z3);
    }

    @Test
    public void canDivideComplexNumbersWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-2.0, -4.0);
        ComplexNumber z2 = new ComplexNumber(-1.0, -2.0);

        ComplexNumber z3 = z1.divide(z2);

        assertEquals(new ComplexNumber(2.0, 0.0), z3);
    }

    @Test
    public void canCalculateArgumentForComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, Math.pow(3.0, 0.5));

        double argument = z1.argument();

        assertEquals(1.047197551, argument, EPSILON);
    }

    @Test
    public void canCalculateArgumentForComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(1.0,  -Math.pow(3.0, 0.5));

        double argument = z1.argument();

        assertEquals(-1.047197551, argument, EPSILON);
    }

    @Test
    public void canCalculateArgumentForComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        double argument = z1.argument();

        assertEquals(0.0, argument, EPSILON);
    }

    @Test
    public void canConvertToStringComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 1.0);

        assertEquals("ComplexNumber{real=1.0, imaginary=1.0}", z1.toString());
    }

    @Test
    public void canConvertToStringComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, -1.0);

        assertEquals("ComplexNumber{real=1.0, imaginary=-1.0}", z1.toString());
    }

    @Test
    public void canConvertToStringComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        assertEquals("ComplexNumber{real=0.0, imaginary=0.0}", z1.toString());
    }

    @Test
    public void canCalculateExpForComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);

        ComplexNumber z2 = z1.exp();

        assertEquals(new ComplexNumber(-1.1312043, 2.4717267), z2);
    }

    @Test
    public void canCalculateExpForComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);

        ComplexNumber z2 = z1.exp();

        assertEquals(new ComplexNumber(-0.1530918, -0.3345118), z2);
    }

    @Test
    public void canCalculateExpForComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z2 = z1.exp();

        assertEquals(new ComplexNumber(1.0, 0.0), z2);
    }

    @Test
    public void canCalculateSinForComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);

        ComplexNumber z2 = z1.sin();

        assertEquals(new ComplexNumber(3.1657785, 1.959601), z2);
    }

    @Test
    public void canCalculateSinForComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);

        ComplexNumber z2 = z1.sin();

        assertEquals(new ComplexNumber(-3.1657785, -1.959601), z2);
    }

    @Test
    public void canCalculateSinForComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z2 = z1.sin();

        assertEquals(new ComplexNumber(0.0, 0.0), z2);
    }

    @Test
    public void canCalculateCosForComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);

        ComplexNumber z2 = z1.cos();

        assertEquals(new ComplexNumber(2.032723, -3.0518977), z2);
    }

    @Test
    public void canCalculateCosForComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);

        ComplexNumber z2 = z1.cos();

        assertEquals(new ComplexNumber(2.032723, -3.0518977), z2);
    }

    @Test
    public void canCalculateCosForComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z2 = z1.cos();

        assertEquals(new ComplexNumber(1.0, 0.0), z2);
    }

    @Test
    public void canCalculateTanForComplexNumberWithPositiveValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);

        ComplexNumber z2 = z1.tan();

        assertEquals(new ComplexNumber(0.0338128, 1.0147936), z2);
    }

    @Test
    public void canCalculateTanForComplexNumberWithNegativeValues() {
        ComplexNumber z1 = new ComplexNumber(-1.0, -2.0);

        ComplexNumber z2 = z1.tan();

        assertEquals(new ComplexNumber(-0.0338128, -1.0147936), z2);
    }

    @Test
    public void canCalculateTanForComplexNumberWithZeroValues() {
        ComplexNumber z1 = new ComplexNumber(0.0, 0.0);

        ComplexNumber z2 = z1.tan();

        assertEquals(new ComplexNumber(0.0, 0.0), z2);
    }
}
