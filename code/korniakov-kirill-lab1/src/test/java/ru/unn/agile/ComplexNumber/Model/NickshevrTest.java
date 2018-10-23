package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NickshevrTest {
    @Test
    public void canEqualsSameNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(1, 0);

        assertTrue(z1.equals(z2));
    }

    @Test
    public void canEqualsNumbersWithDiffenentArgType() {
        ComplexNumber z1 = new ComplexNumber(1.0, 0);
        ComplexNumber z2 = new ComplexNumber(1, 0);

        assertTrue(z1.equals(z2));
    }

    @Test
    public void canEqualsNumberWithDifferentArgs() {
        ComplexNumber z1 = new ComplexNumber(2, 2);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        assertFalse(z1.equals(z2));
    }
}
