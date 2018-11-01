package ru.unn.agile.fraction.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionalNumbersCalcTest {
    @Test
    public void canCreateFractionalNumberWithInitialValues() {
        // Arrange
        Fraction fractionalNumber = new Fraction(1, 2);

        // Act & Assert
        assertNotNull(fractionalNumber);
    }
}
