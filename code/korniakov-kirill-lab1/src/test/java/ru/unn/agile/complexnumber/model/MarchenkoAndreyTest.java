package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarchenkoAndreyTest {
    @Test
    public void canAddZeroComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(0, 0);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(2, 1);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(0, 5), z);
    }

    @Test
    public void canExtractRealFromComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(1.11, 2);

        double real = z1.getReal();

        assertEquals(1.11, real, 0.00001);
    }
}
