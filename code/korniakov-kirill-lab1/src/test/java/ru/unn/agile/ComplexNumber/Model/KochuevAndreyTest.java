package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class KochuevAndreyTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);
        // Act
        ComplexNumber z = z1.add(z2);
        // Assert
        assertEquals(new ComplexNumber(1, 1), z);
    }

    @Test
    public void canConvertToString() {
        // Arrange
        ComplexNumber z = new ComplexNumber(1, 1);
        // Act
        String zstr = z.toString();
        // Assert
        assertEquals("1.0 + 1.0i", zstr);
    }

    @Test
    public void areNotEqualNumbersEqual() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1.02, 4.33);
        ComplexNumber z2 = new ComplexNumber(1.02, 4.73);
        // Act
        boolean isEqual = z1.equals(z2);
        // Assert
        assertFalse(isEqual);
    }
}
