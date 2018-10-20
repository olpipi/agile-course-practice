package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreev Vladislav on 19.10.2018.
 */
public class AndreevVladislavTest {
    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(1, 1), z);
    }

    @Test
    public void canAddNegativeNumbers() {
        ComplexNumber z1 = new ComplexNumber(-1, 0);
        ComplexNumber z2 = new ComplexNumber(-2, 1);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(-3, 1), z);
    }

    @Test
    public void canAddZeroNumbers() {
        ComplexNumber z1 = new ComplexNumber(0, 0);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canToString() {
        ComplexNumber z1 = new ComplexNumber(-3.2, 5.7);

        String z1String = z1.toString();

        assertEquals("-3.2 + 5.7i", z1String);
    }
}
