package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ComplexNumberTest {

    @Test(expected = NullPointerException.class)
    public void canCreateComplexNumberWithNullValues() {
        Double real = null;
        Double imaginary = null;

        new ComplexNumber(real, imaginary);
    }

    @Test
    public void canCreateComplexNumberWithInitialValues() {
        ComplexNumber number = new ComplexNumber(1, 1);
        assertNotNull(number);
    }

}