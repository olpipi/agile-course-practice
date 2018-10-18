package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoiseevNikitaTest {
    @Test
    public void canInstantiate() {
        ComplexNumber z = new ComplexNumber(42, 24);
        assertNotNull(z);
    }

    @Test
    public void canInstantiateWithCorrectValues() {
        double real = 42.123456789012345;
        double imaginary = 24.123456789012345;
        ComplexNumber z = new ComplexNumber(real, imaginary);

        double delta = Math.pow(10, -15);
        assertEquals(z.getReal(), real, delta);
        assertEquals(z.getImaginary(), imaginary, delta);
    }

    @Test
    public void canCompare() {
        double real = 1.234;
        double imaginary = 9.876;
        ComplexNumber z1 = new ComplexNumber(real, imaginary);
        ComplexNumber z2 = new ComplexNumber(real, imaginary);

        assertEquals(z1, z2);
    }
}

