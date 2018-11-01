package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GolovanovaTatyanaTest {

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);

        ComplexNumber complexNumberForChecking = new ComplexNumber(3, 3);
        ComplexNumber addingComplexNumbers = complexNumber1.add(complexNumber2);

        assertEquals(addingComplexNumbers, complexNumberForChecking);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);

        ComplexNumber complexNumberForChecking = new ComplexNumber(0, 4);
        ComplexNumber multiplyComplexNumbers = complexNumber1.multiply(complexNumber2);

        assertEquals(multiplyComplexNumbers, complexNumberForChecking);
    }

    @Test
    public void canGetRealOfComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(10, 1);

        String checkReal = "10.0";
        double strReal = complexNumber.getReal();

        assertEquals(checkReal, checkReal);
    }

    @Test
    public void canToStringComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(10, 1);

        String checkStrComplexNumber = "10.0 + 1.0i";
        String strComplexNumber = complexNumber.toString();

        assertEquals(checkStrComplexNumber, strComplexNumber);
    }
}

