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
	@Test
    public void canMultiplyFractionNumbersWithPositiveValues() {
        // Arrange
        Fraction fracNumber1 = new Fraction(1, 5);
        Fraction fracNumber2 = new Fraction(2, 3);

        // Act
        Fraction multiplyResult = fracNumber1.multiply(fracNumber2);

        // Assert
        assertTrue(multiplyResult.equals(new Fraction(2, 15)));
    }
    @Test
    public void canMultiplyFractionNumbersWithNegativeValue() {
        // Arrange
        Fraction fracNumber1 = new Fraction(-1, 5);
        Fraction fracNumber2 = new Fraction(2, 3);

        // Act
        Fraction multiplyResult = fracNumber1.multiply(fracNumber2);

        // Assert
        assertTrue(multiplyResult.equals(new Fraction(-2, 15)));
    }
    @Test
    public void canDivideFractionNumbersWithPositiveValues() {
        // Arrange
        Fraction fracNumber1 = new Fraction(1, 5);
        Fraction fracNumber2 = new Fraction(2, 3);

        // Act
        Fraction divideResult = fracNumber1.divide(fracNumber2);

        // Assert
        assertTrue(divideResult.equals(new Fraction(3, 10)));
    }
    @Test
    public void canDivideFractionNumbersWithNegativeValues() {
        // Arrange
        Fraction fracNumber1 = new Fraction(-1, 5);
        Fraction fracNumber2 = new Fraction(-2, 3);

        // Act
        Fraction divideResult = fracNumber1.divide(fracNumber2);

        // Assert
        assertTrue(divideResult.equals(new Fraction(3, 10)));
    }
    @Test(expected = ArithmeticException.class)
    public void canDivideFractionNumbersWithZeroNumerator() {
        // Arrange
        Fraction fracNumber1 = new Fraction(-1, 5);
        Fraction fracNumber2 = new Fraction(0, 3);

        // Act
        Fraction divideResult = fracNumber1.divide(fracNumber2);
    }
    @Test
    public void canAddFractionNumbers() {
        // Arrange
        Fraction fracNumber1 = new Fraction(1, 5);
        Fraction fracNumber2 = new Fraction(2, 3);

        // Act
        Fraction addResult = fracNumber1.addNoGcd(fracNumber2);
        String res = addResult.toString();

        // Assert
        assertEquals("13/15", res);
    }
    @Test
    public void canAddFractionNumbersWithGcd() {
        // Arrange
        Fraction fracNumber1 = new Fraction(2, 8);
        Fraction fracNumber2 = new Fraction(7, 3);

        // Act
        Fraction addResult = fracNumber1.addWithGcd(fracNumber2);
        String res = addResult.toString();

        // Assert
        assertEquals("31/12", res);
    }
    @Test
    public void canSubstractFractionNumbersWithPositiveValues() {
        // Arrange
        Fraction fracNumber1 = new Fraction(2, 8);
        Fraction fracNumber2 = new Fraction(7, 3);

        // Act
        Fraction addResult = fracNumber1.substract(fracNumber2);
        String res = addResult.toString();

        // Assert
        assertEquals("-25/12", res);
    }
    @Test
    public void canSubstractFractionNumbersWithNegativeValues() {
        // Arrange
        Fraction fracNumber1 = new Fraction(-1, 9);
        Fraction fracNumber2 = new Fraction(-3, 9);

        // Act
        Fraction addResult = fracNumber1.substract(fracNumber2);
        String res = addResult.toString();

        // Assert
        assertEquals("2/9", res);
    }
    @Test
    public void canSubstractFractionNumbersWithZeroValue() {
        // Arrange
        Fraction fracNumber1 = new Fraction(4, 9);
        Fraction fracNumber2 = new Fraction(0, 5);

        // Act
        Fraction addResult = fracNumber1.substract(fracNumber2);
        String res = addResult.toString();

        // Assert
        assertEquals("4/9", res);
    }
    @Test(expected = ArithmeticException.class)
    public void canDenominationBeZero() {
        Fraction fracNumber2 = new Fraction(2, 0);
    }
    @Test(expected = ArithmeticException.class)
    public void canDenominationBeLessThanZero() {
        Fraction fracNumber2 = new Fraction(2, -1);
    }
}
