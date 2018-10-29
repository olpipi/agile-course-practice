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

    @Test
    public void convertToRomanTheNumber2Converted() {
        // Arrange
        int arabicNumber = 2;

        // Act
        String romanNumber = RomanNumberConverter.convertToRoman(arabicNumber);

        // Assert
        assertEquals("II", romanNumber);
    }

    @Test
    public void convertToRomanTheNumber4Converted() {
        // Arrange
        int arabicNumber = 4;

        // Act
        String romanNumber = RomanNumberConverter.convertToRoman(arabicNumber);

        // Assert
        assertEquals("IV", romanNumber);
    }
}
