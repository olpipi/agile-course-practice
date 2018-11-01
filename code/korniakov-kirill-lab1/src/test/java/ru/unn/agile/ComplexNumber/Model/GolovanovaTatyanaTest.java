package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GolovanovaTatyanaTest {
    private final double delta = 0.001;

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);

        ComplexNumber expectedComplexNumber = new ComplexNumber(3, 3);
        ComplexNumber addingComplexNumbers = complexNumber1.add(complexNumber2);

        assertEquals(expectedComplexNumber, addingComplexNumbers);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);

        ComplexNumber expectedComplexNumber = new ComplexNumber(0, 4);
        ComplexNumber multiplyComplexNumbers = complexNumber1.multiply(complexNumber2);

        assertEquals(expectedComplexNumber, multiplyComplexNumbers);
    }

    @Test
    public void canGetRealOfComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(10, 1);

        double expectedReal = 10.0;
        double real = complexNumber.getReal();

        assertEquals(expectedReal, real, delta);
    }

    @Test
    public void canToStringComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(10, 1);

        String expectedStrComplexNumber = "10.0 + 1.0i";
        String strComplexNumber = complexNumber.toString();

        assertEquals(expectedStrComplexNumber, strComplexNumber);
    }
}

