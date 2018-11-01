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

        // Act
        frac.setNumerator(5);

        // Assert
        assertEquals(5, frac.getNumerator());
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
    public void canConvertToStringFractionNumberWithPositiveValues() {
        // Arrange
        Fraction fractionalNumber = new Fraction(1, 2);

        // Act & Assert
        assertEquals("1/2", fractionalNumber.toString());
    }
    @Test
    public void canConvertToStringFractionNumberWithNegativeValue() {
        // Arrange
        Fraction fractionalNumber = new Fraction(-1, 2);

        // Act & Assert
        assertEquals("-1/2", fractionalNumber.toString());
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
        Fraction frac1 = new Fraction(1, 5);
        Fraction frac2 = new Fraction(2, 3);

        // Act
        Fraction multiplyResult = frac1.multiply(frac2);

        // Assert
        assertTrue(multiplyResult.equals(new Fraction(2, 15)));
    }
    @Test
    public void canMultiplyFractionNumbersWithNegativeValue() {
        // Arrange
        Fraction frac1 = new Fraction(-1, 5);
        Fraction frac2 = new Fraction(2, 3);

        // Act
        Fraction multiplyResult = frac1.multiply(frac2);

        // Assert
        assertTrue(multiplyResult.equals(new Fraction(-2, 15)));
    }
    @Test
    public void canDivideFractionNumbersWithPositiveValues() {
        // Arrange
        Fraction frac1 = new Fraction(1, 5);
        Fraction frac2 = new Fraction(2, 3);

        // Act
        Fraction divideResult = frac1.divide(frac2);

        // Assert
        assertTrue(divideResult.equals(new Fraction(3, 10)));
    }
    @Test
    public void canDivideFractionNumbersWithNegativeValues() {
        // Arrange
        Fraction frac1 = new Fraction(-1, 5);
        Fraction frac2 = new Fraction(-2, 3);

        // Act
        Fraction divideResult = frac1.divide(frac2);

        // Assert
        assertTrue(divideResult.equals(new Fraction(3, 10)));
    }
    @Test(expected = ArithmeticException.class)
    public void canDivideFractionNumbersWithZeroNumerator() {
        // Arrange
        Fraction frac1 = new Fraction(-1, 5);
        Fraction frac2 = new Fraction(0, 3);

        // Act
        Fraction divideResult = frac1.divide(frac2);
    }
    @Test
    public void canAddFractionNumbers() {
        // Arrange
        Fraction frac1 = new Fraction(1, 5);
        Fraction frac2 = new Fraction(2, 3);

        // Act
        Fraction addResult = frac1.addNoGcd(frac2);
        String res = addResult.toString();

        // Assert
        assertEquals("13/15", res);
    }
    @Test
    public void canAddFractionNumbersWithGcd() {
        // Arrange
        Fraction frac1 = new Fraction(2, 8);
        Fraction frac2 = new Fraction(7, 3);

        // Act
        Fraction addResult = frac1.addWithGcd(frac2);
        String res = addResult.toString();

        // Assert
        assertEquals("31/12", res);
    }
    @Test
    public void canSubstractFractionNumbersWithPositiveValues() {
        // Arrange
        Fraction frac1 = new Fraction(2, 8);
        Fraction frac2 = new Fraction(7, 3);

        // Act
        Fraction addResult = frac1.substract(frac2);
        String res = addResult.toString();

        // Assert
        assertEquals("-25/12", res);
    }
    @Test
    public void canSubstractFractionNumbersWithNegativeValues() {
        // Arrange
        Fraction frac1 = new Fraction(-1, 9);
        Fraction frac2 = new Fraction(-3, 9);

        // Act
        Fraction addResult = frac1.substract(frac2);
        String res = addResult.toString();

        // Assert
        assertEquals("2/9", res);
    }
    @Test
    public void canSubstractFractionNumbersWithZeroValue() {
        // Arrange
        Fraction frac1 = new Fraction(4, 9);
        Fraction frac2 = new Fraction(0, 5);

        // Act
        Fraction addResult = frac1.substract(frac2);
        String res = addResult.toString();

        // Assert
        assertEquals("4/9", res);
    }
    @Test(expected = ArithmeticException.class)
    public void canDenominationBeZero() {
        Fraction frac = new Fraction(2, 0);
    }
    @Test(expected = ArithmeticException.class)
    public void canDenominationBeLessThanZero() {
        Fraction frac = new Fraction(2, -1);
    }
}
