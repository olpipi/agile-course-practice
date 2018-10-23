package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OsechkinSergeyTest {
    @Test
    public void canAddComplexNumbers1() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(1, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(2, 2), z);
    }

    @Test
    public void checkZeroComplexNumber() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(-1, -1);
        ComplexNumber z2 = new ComplexNumber(1, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void checkToStringComplexNumber() {
        // Arrange
        ComplexNumber z = new ComplexNumber(-1, -1);

        // Assert
        assertEquals("-1.0 - 1.0i", z.toString());
    }

    @Test
    public void checkImaginaryPartWhenMultiplyComplexNumber() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(-5, -3);
        ComplexNumber z2 = new ComplexNumber(1, 1);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(true, z.getImaginary() == -8);
    }

    @Test
    public void canAddComplexNumbers2() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(0, 0);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }
}
