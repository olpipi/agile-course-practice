package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ShiryaevaEkaterinaTest {
    @Test
    public void canCompareComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(-1, 2);

        assertFalse(z1.equals(z2));
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, -2);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(1, -1), z);
    }

    @Test
    public void canConvertToString() {
        ComplexNumber z1 = new ComplexNumber(1, 2);

        assertEquals("1.0 + 2.0i", z1.toString());
    }
}
