package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnikinaOlgaTest {

    @Test
    public void addComplexNumber() {

        ComplexNumber number1 = new ComplexNumber(4, 4);
        ComplexNumber number2 = new ComplexNumber(1, 1);

        ComplexNumber number3 = number1.add(number2);


        assertEquals(new ComplexNumber(5, 5), number3);
    }

    @Test
    public void multiplyToZero() {

        ComplexNumber number1 = new ComplexNumber(1, 4);
        ComplexNumber number2 = new ComplexNumber(0, 0);

        ComplexNumber number3 = number1.multiply(number2);

        assertEquals(new ComplexNumber(0, 0), number3);
    }

    @Test
    public void multiplyComplexNumber() {

        ComplexNumber number1 = new ComplexNumber(1, 4);
        ComplexNumber number2 = new ComplexNumber(3, 4);

        ComplexNumber number3 = number1.multiply(number2);

        assertEquals(new ComplexNumber(-13, 16), number3);
    }
}
