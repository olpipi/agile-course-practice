package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PozdiaevValeriiTest {
    @Test
    public void canMultiplyComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(-1, -1);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(0, -2), z);
    }

    @Test
    public void canMultiplyComplexNumberWithZero() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 1);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canAddComplexNumberWithOpposite() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 1);
        ComplexNumber z2 = new ComplexNumber(-2, -1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }
}
