package ru.unn.agile.currencyconverter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyConverterTest {
    private final double delta = 0.001;

    @Test
    public void canConvertRubToUsd() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 100;

        // Act
        double dollarsAmount = currencyConverter.convertRubToUsd(rublesAmount);

        // Assert
        double expectedDollarsAmount = 1.5;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }
}
