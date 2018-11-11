package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagazinnikIvanTest {
    @Test
    public void canGetMaxDoubleImaginaryPart() {
        ComplexNumber z = new ComplexNumber(0, Double.MAX_VALUE);

        double imaginary = z.getImaginary();

        assertEquals(imaginary, Double.MAX_VALUE, 0.000001);
    }

    @Test
    public void canGetMaxDoubleRealPart() {
        ComplexNumber z = new ComplexNumber(Double.MAX_VALUE, 0);

        double real = z.getReal();

        assertEquals(real, Double.MAX_VALUE, 0.000001);
    }

    @Test
    public void canAddNumbersWithMaxRealAndImaginaryParts() {
        ComplexNumber z1 = new ComplexNumber(Double.MAX_VALUE, 0);
        ComplexNumber z2 = new ComplexNumber(0, Double.MAX_VALUE);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE), z);
    }
}
