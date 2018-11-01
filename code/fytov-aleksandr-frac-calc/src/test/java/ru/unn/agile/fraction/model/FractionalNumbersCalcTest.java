package ru.unn.agile.fraction.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionalNumbersCalcTest {
    @Test
    public void canCreateFractionalNumberWithInitialValues() {
        // Arrange
        Fraction fractionalNumber = new Fraction(1, 2);

        // Act & Assert
        assertNotNull(fractionalNumber);
    }
	@Test
    public void canGetInitialNumeratorValue() {
        // Arrange
        Fraction number = new Fraction(1, 2);

        // Act & Assert
        assertEquals(1, number.getNumerator());
    }
    @Test
    public void canGetInitialDenominatorValue() {
        // Arrange
        Fraction number = new Fraction(1, 2);

        // Act & Assert
        assertEquals(2, number.getDenominator());
    }
	@Test
    public void canSetInitialNumeratorValue() {
        // Arrange
        Fraction number = new Fraction(1, 2);

		//Act
		number.setNumerator(5);
		
        //Assert
        assertEquals(5, number.getNumerator());
    }
    @Test
    public void canSetInitialDenominatorValue() {
        // Arrange
        Fraction number = new Fraction(1, 2);
		
		//Act
		number.setDenominator(5);
		
        //Assert
        assertEquals(5, number.getDenominator());
    }
}
