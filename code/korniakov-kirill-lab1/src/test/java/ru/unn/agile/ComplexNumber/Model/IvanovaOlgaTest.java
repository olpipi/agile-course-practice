package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class IvanovaOlgaTest {

    @Test
    public void canAddComplexNumber() {
        ComplexNumber complexNumber1 = new ComplexNumber(3, 3);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);

        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);

        assertEquals(new ComplexNumber(5, 5), complexNumber3);
    }

    @Test
    public void canMultiplyComplexNumber() {
        ComplexNumber complexNumber1 = new ComplexNumber(3, 3);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 3);

        ComplexNumber complexNumber3 = complexNumber1.multiply(complexNumber2);

        assertEquals(new ComplexNumber(-3, 15), complexNumber3);
    }

    @Test
    public void canAddZeroNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(5, 5);
        ComplexNumber complexNumber2 = new ComplexNumber(0, 0);

        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);

        assertEquals(new ComplexNumber(5, 5), complexNumber3);
    }

}
