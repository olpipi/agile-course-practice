package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OsechkinSergeyTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(1, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(2, 2), z);
    }

    @Test
    public void canAddOppositeComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(-1, -1);
        ComplexNumber z2 = new ComplexNumber(1, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canConvertComplexNumberToString() {
        // Arrange
        ComplexNumber z = new ComplexNumber(-1, -1);

        // Act
        String strComplex = z.toString();

        // Assert
        assertEquals("-1.0 - 1.0i", strComplex);
    }

    @Test
    public void canExtractImaginaryPartComplexNumber() {
        // Arrange
        ComplexNumber z = new ComplexNumber(-5, -3);

        // Act
        double im = z.getImaginary();

        // Assert
        assertEquals(-3, im, 0.001);
    }

    @Test
    public void canAddZeroComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(0, 0);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }
}
