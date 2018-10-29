package ru.unn.agile.romannumberconverter.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RomanNumberConverterToArabicTest {
    @Test
    public void convertToArabicTheNumber1Converted() {
        // Arrange
        String romanNumber = "I";

        // Act
        int arabicNumber = RomanNumberConverter.convertToArabic(romanNumber);

        // Assert
        assertEquals(1, arabicNumber);
    }

    @Test
    public void convertToArabicTheNumber3Converted() {
        // Arrange
        String romanNumber = "III";

        // Act
        int arabicNumber = RomanNumberConverter.convertToArabic(romanNumber);

        // Assert
        assertEquals(3, arabicNumber);
    }

    @Test
    public void convertToArabicTheNumber4Converted() {
        // Arrange
        String romanNumber = "IV";

        // Act
        int arabicNumber = RomanNumberConverter.convertToArabic(romanNumber);

        // Assert
        assertEquals(4, arabicNumber);
    }

    @Test
    public void convertToArabicTheNumber5Converted() {
        // Arrange
        String romanNumber = "V";

        // Act
        int arabicNumber = RomanNumberConverter.convertToArabic(romanNumber);

        // Assert
        assertEquals(5, arabicNumber);
    }

    @Test
    public void convertToArabicTheNumber9Converted() {
        // Arrange
        String romanNumber = "IX";

        // Act
        int arabicNumber = RomanNumberConverter.convertToArabic(romanNumber);

        // Assert
        assertEquals(9, arabicNumber);
    }
}

