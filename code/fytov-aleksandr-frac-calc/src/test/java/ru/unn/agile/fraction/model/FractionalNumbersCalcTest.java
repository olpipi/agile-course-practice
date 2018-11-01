package ru.unn.agile.fraction.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionalNumbersCalcTest {
    @Test
    public void canCreateFractionalNumberWithInitialValues() {
        // Arrange
        Fraction frac = new Fraction(1, 2);

        // Act & Assert
        assertNotNull(frac);
    }
	@Test
    public void canGetInitialNumeratorValue() {
        // Arrange
        Fraction frac = new Fraction(1, 2);

        // Act & Assert
        assertEquals(1, frac.getNumerator());
    }
    @Test
    public void canGetInitialDenominatorValue() {
        // Arrange
        Fraction frac = new Fraction(1, 2);

        // Act & Assert
        assertEquals(2, frac.getDenominator());
    }
	@Test
    public void canSetInitialNumeratorValue() {
        // Arrange
        Fraction frac = new Fraction(1, 2);

		//Act
		frac.setNumerator(5);
		
        //Assert
        assertEquals(5, frac.getNumerator());
    }
    @Test
    public void canSetInitialDenominatorValue() {
        // Arrange
        Fraction frac = new Fraction(1, 2);
		
		//Act
		frac.setDenominator(5);
		
        //Assert
        assertEquals(5, frac.getDenominator());
    }
	 @Test
    public void canConvertToStringFractionNumberWithPositiveValues() {
        // Arrange
        Fraction frac = new Fraction(1, 2);

        // Act & Assert
        assertEquals("1/2", frac.toString());
    }
    @Test
    public void canConvertToStringFractionNumberWithNegativeValue() {
        // Arrange
        Fraction frac = new Fraction(-1, 2);

        // Act & Assert
        assertEquals("-1/2", frac.toString());
    }
	@Test
    public void isFractionNumberEqualToItSelf() {
        Fraction frac1 = new Fraction(1, 2);

        assertEquals(frac1, frac1);
    }
    @Test
    public void isNullEqualToFractionNumber() {
        Fraction frac1 = new Fraction(1, 1);

        assertNotEquals(null, frac1);
    }
	@Test
    public void areEqualFractionNumbersEqual() {
        // Arrange
        Fraction frac1 = new Fraction(3, 5);
        Fraction frac2 = new Fraction(3, 5);

        // Act & Assert
        assertTrue(frac1.equals(frac2));
    }
    @Test
    public void areDifferentFractionNumbersNotEqual() {
        // Arrange
        Fraction frac1 = new Fraction(3, 5);
        Fraction frac2 = new Fraction(1, 2);

        // Act & Assert
        assertFalse(frac1.equals(frac2));
    }
    @Test
    public void areFractionNumbersWithDifferentNumeratorNotEqual() {
        // Arrange
        Fraction frac1 = new Fraction(1, 8);
        Fraction frac2 = new Fraction(3, 8);

        // Act & Assert
        assertFalse(frac1.equals(frac2));
    }
    @Test
    public void areFractionNumbersWithDifferentDenominatorNotEqual() {
        // Arrange
        Fraction frac1 = new Fraction(3, 5);
        Fraction frac2 = new Fraction(3, 4);

        // Act & Assert
        assertFalse(frac1.equals(frac2));
    }
}
