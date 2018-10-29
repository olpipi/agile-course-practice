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

    @Test
    public void convertToRomanTheNumber5Converted() {
        // Arrange
        int arabicNumber = 5;

        // Act
        String romanNumber = RomanNumberConverter.convertToRoman(arabicNumber);

        // Assert
        assertEquals("V", romanNumber);
    }

    @Test
    public void convertToRomanTheNumber7Converted() {
        // Arrange
        int arabicNumber = 7;

        // Act
        String romanNumber = RomanNumberConverter.convertToRoman(arabicNumber);

        // Assert
        assertEquals("VII", romanNumber);
    }

    @Test
    public void convertToRomanTheNumber9Converted() {
        // Arrange
        int arabicNumber = 9;

        // Act
        String romanNumber = RomanNumberConverter.convertToRoman(arabicNumber);

        // Assert
        assertEquals("IX", romanNumber);
    }
}
