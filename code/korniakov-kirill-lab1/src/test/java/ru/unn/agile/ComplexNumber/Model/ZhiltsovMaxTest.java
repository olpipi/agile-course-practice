package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZhiltsovMaxTest {
    @Test
    public void canMultiplyRealComplexNumbers() {
        ComplexNumber a = new ComplexNumber(2, 0);
        ComplexNumber b = new ComplexNumber(-4, 0);

        ComplexNumber result = a.multiply(b);

        assertEquals(new ComplexNumber(-8, 0), result);
    }

    @Test
    public void canMultiplyImaginaryComplexNumbers() {
        ComplexNumber a = new ComplexNumber(0, -3);
        ComplexNumber b = new ComplexNumber(0, 2);

        ComplexNumber result = a.multiply(b);

        assertEquals(new ComplexNumber(6, 0), result);
    }
}
