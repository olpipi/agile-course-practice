package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PolyakovIgorTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(-1, 1);
        ComplexNumber z2 = new ComplexNumber(2, -1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(1, 0), z);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(-1, 0);
        ComplexNumber z2 = new ComplexNumber(2, -1);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(-2, 1), z);
    }

    @Test
    public void areComplexNumbersWithSameRealAndImaginaryPartsEqual() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(1, 0);

        // Act & Assert
        assertTrue(z1.equals(z2));
    }
}
