package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NakhimovichDmitryTest {
    @Test
    public void canEqualsComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(1, 1);

        assertTrue(complexNumber1.equals(complexNumber2));
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, -2);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(1, -1), z);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(1, -1);

        ComplexNumber complexNumberResult = complexNumber1.multiply(complexNumber2);

        assertEquals(new ComplexNumber(2, 0), complexNumberResult);
    }

    @Test
    public void canToStringComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(66, -66);

        assertEquals("66.0 - 66.0i", complexNumber.toString());
    }
}