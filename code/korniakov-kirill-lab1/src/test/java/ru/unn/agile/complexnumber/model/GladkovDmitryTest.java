package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GladkovDmitryTest {
    @Test
    public void canAddComplexNumbers() {
        ComplexNumber cn1 = new ComplexNumber(1900, -300);
        ComplexNumber cn2 = new ComplexNumber(200, -700);

        ComplexNumber cn = cn1.add(cn2);

        assertEquals(new ComplexNumber(2100, -1000), cn);
    }

    @Test
    public void canToStringComplexNumber() {
        ComplexNumber cn = new ComplexNumber(-0.19, 195.00001);

        assertEquals("-0.19 + 195.0i", cn.toString());
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber cn1 = new ComplexNumber(5.99, -1.49);
        ComplexNumber cn2 = new ComplexNumber(-2, 2);

        ComplexNumber cn = cn1.multiply(cn2);

        assertEquals(new ComplexNumber(-9.0, 14.96), cn);
    }
}
