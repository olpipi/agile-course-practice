package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RumyantsevAlexanderTest {
    @Test
    public void canCompareComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(0, 1);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        assertEquals(z1, z2);
    }

    @Test
    public void canConvertComplexNumberToString() {
        ComplexNumber z = new ComplexNumber(-3, 4);

        String s = z.toString();

        assertEquals("-3.0 + 4.0i", s);
    }

    @Test
    public void canGetRealAndImaginaryFromComplexNumber() {
        ComplexNumber z = new ComplexNumber(1.25, 0.17);

        double real = z.getReal();
        double imaginary = z.getImaginary();

        assertEquals(1.25, real, 0.000001);
        assertEquals(0.17, imaginary, 0.000001);
    }
}
