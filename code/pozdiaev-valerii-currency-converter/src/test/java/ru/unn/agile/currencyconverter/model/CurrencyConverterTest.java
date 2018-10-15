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
        String RUBLES_CURRENCY_CODE = "RUB";
        String DOLLARS_CURRENCY_CODE = "USD";

        // Act
        double dollarsAmount = currencyConverter.convert(RUBLES_CURRENCY_CODE, DOLLARS_CURRENCY_CODE, rublesAmount);

        // Assert
        double expectedDollarsAmount = 1.5;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }

    @Test
    public void canConvertRubToEuro() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 100;
        String RUBLES_CURRENCY_CODE = "RUB";
        String EURO_CURRENCY_CODE = "EUR";

        // Act
        double euroAmount = currencyConverter.convert(RUBLES_CURRENCY_CODE, EURO_CURRENCY_CODE, rublesAmount);

        // Assert
        double expectedEuroAmount = 1.3;
        assertEquals(expectedEuroAmount, euroAmount, delta);
    }

    @Test
    public void canCreateCurrencyPair() {
        // Arrange
        String RUBLES_CURRENCY_CODE = "RUB";
        String DOLLARS_CURRENCY_CODE = "USD";
        double rubToUsdRate = 0.013;

        // Act
        CurrencyPair currencyPair = new CurrencyPair(RUBLES_CURRENCY_CODE, DOLLARS_CURRENCY_CODE, rubToUsdRate);

        // Assert
        assertEquals(rubToUsdRate, currencyPair.getRate(), delta);
    }
}
