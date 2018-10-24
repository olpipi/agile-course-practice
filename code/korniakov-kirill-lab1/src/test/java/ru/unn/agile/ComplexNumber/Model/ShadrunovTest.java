package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShadrunovTest {
    private final double delta = 0;

    @Test
    public void canAddRealParts() {
        ComplexNumber firstNumber = new ComplexNumber(1, 0);
        ComplexNumber secondNumber = new ComplexNumber(2, 1);

        ComplexNumber sum = firstNumber.add(secondNumber);

        assertEquals(3.0, sum.getReal(), delta);
    }

    @Test
    public void canAddImagimaryParts() {
        ComplexNumber firstNumber = new ComplexNumber(1, 3);
        ComplexNumber secondNumber = new ComplexNumber(2, 2);

        ComplexNumber sum = firstNumber.add(secondNumber);

        assertEquals(5.0, sum.getImaginary(), delta);
    }

    @Test
    public void canMultiplyOnZero() {
        ComplexNumber number = new ComplexNumber(4, 3);
        ComplexNumber zero = new ComplexNumber(0, 0);

        ComplexNumber multyplyResult = number.multiply(zero);

        assertTrue(zero.equals(multyplyResult));
    }
}
