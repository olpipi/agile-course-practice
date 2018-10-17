package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShadrunovTests {
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
    public void canInitializeWithZeros() {
        ComplexNumber number = new ComplexNumber(0, 0);

        assertEquals(0, number.getReal(), delta);
        assertEquals(0, number.getImaginary(), delta);
    }
}
