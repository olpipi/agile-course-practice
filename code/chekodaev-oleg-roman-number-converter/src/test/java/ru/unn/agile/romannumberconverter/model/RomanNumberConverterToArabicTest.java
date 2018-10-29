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
}

