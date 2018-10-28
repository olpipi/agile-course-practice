package ru.unn.agile.romannumberconverter.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RomanNumberConverterToRomanTest {
    @Test
    public void convertToRomanTheNumber1Converted() {
        // Arrange
        int arabicNumber = 1;

        // Act
        String romanNumber = RomanNumberConverter.convertToRoman(arabicNumber);

        // Assert
        assertEquals("I", romanNumber);
    }
}
