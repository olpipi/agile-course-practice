package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChekodaevOlegTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(0, 2);
        ComplexNumber z2 = new ComplexNumber(4, -2);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(4, 0), z);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(0, 2);
        ComplexNumber z2 = new ComplexNumber(4, -2);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(4, 8), z);
    }

    @Test
    public void canToStringComplexNumber() {
        // Arrange
        ComplexNumber z = new ComplexNumber(4, -2);

        // Act & Assert
        assertEquals("4.0 - 2.0i", z.toString());
    }
}
