package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class BeresnevaJuliaTest {
    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, -1);
        ComplexNumber z2 = new ComplexNumber(-1, 1);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canGetRealPart() {
        ComplexNumber z = new ComplexNumber(1, 2);

        double real = z.getReal();

        assertEquals(1, real, 0.001);
    }

    @Test
    public void canMuliplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(2, -1);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(4, 3), z);
    }
}
