package ru.unn.agile.currencyconverter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurrencyConverterTest {
    private final double delta = 0.001;

    private static final String RUB_CODE = "RUB";
    private static final String USD_CODE = "USD";
    private static final String EURO_CODE = "EUR";

    @Test
    public void canConvertRubToUsd() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 100;

        // Act
        double dollarsAmount = currencyConverter.convert(RUB_CODE, USD_CODE, rublesAmount);

        // Assert
        double expectedDollarsAmount = 1.5;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }

    @Test
    public void canConvertRubToEuro() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 100;

        // Act
        double euroAmount = currencyConverter.convert(RUB_CODE, EURO_CODE, rublesAmount);

        // Assert
        double expectedEuroAmount = 1.3;
        assertEquals(expectedEuroAmount, euroAmount, delta);
    }

    @Test
    public void canCreateCurrencyPair() {
        // Arrange
        double rubToUsdRate = 0.013;

        // Act
        CurrencyPair currencyPair = new CurrencyPair(RUB_CODE, USD_CODE, rubToUsdRate);

        // Assert
        assertEquals(rubToUsdRate, currencyPair.getRate(), delta);
    }

    @Test
    public void canAddCurrencyPairToConverter() {
        // Arrange
        double rubToUsdRate = 0.013;
        CurrencyPair currencyPair = new CurrencyPair(RUB_CODE, USD_CODE, rubToUsdRate);
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act
        currencyConverter.addCurrencyPair(currencyPair);

        // Assert
        assertNotNull(currencyConverter.getCurrencyPair());
    }
}
