package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class KochuevAndreyTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber number1 = new ComplexNumber(1, 0);
        ComplexNumber number2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber summa = number1.add(number2);

        // Assert
        assertEquals(new ComplexNumber(1, 1), summa);
    }

    @Test
    public void canConvertToString() {
        // Arrange
        ComplexNumber number = new ComplexNumber(1, 1);

        // Act
        String strNumber = number.toString();

        // Assert
        assertEquals("1.0 + 1.0i", strNumber);
    }

    @Test
    public void areNotEqualNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1.02, 4.33);
        ComplexNumber z2 = new ComplexNumber(1.02, 4.73);

        // Act
        boolean isEqual = z1.equals(z2);

        // Assert
        assertFalse(isEqual);
    }
}
