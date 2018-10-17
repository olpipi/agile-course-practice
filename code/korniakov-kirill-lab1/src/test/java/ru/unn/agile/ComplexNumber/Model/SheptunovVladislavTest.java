package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SheptunovVladislavTest {
    @Test
    public void canEqualsComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(1, 1);

        assertTrue(complexNumber1.equals(complexNumber2));
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(1, -1);

        ComplexNumber complexNumberResult = complexNumber1.add(complexNumber2);

        assertEquals(new ComplexNumber(2, 0), complexNumberResult);
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
        ComplexNumber complexNumber = new ComplexNumber(1, -1);

        assertEquals("1.0 - 1.0i", complexNumber.toString());
    }
}
