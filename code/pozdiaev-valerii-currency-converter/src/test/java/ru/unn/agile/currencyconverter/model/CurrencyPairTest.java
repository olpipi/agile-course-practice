package ru.unn.agile.currencyconverter.model;

import org.junit.Test;
import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

public class CurrencyPairTest {
    private static final String RUB_CODE = "RUB";
    private static final String USD_CODE = "USD";
    private static final double RUB_TO_USD_RATE = 0.015;

    @Test(expected = CurrencyConverterException.class)
    public void cannotCreatePairWithNegativeRate() {
        // Arrange
        double negativeRate = -20.2;

        // Act & Assert
        new CurrencyPair(RUB_CODE, USD_CODE, negativeRate);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotCreatePairWithIncorrectCode() {
        // Arrange
        String incorrectCode = "asdadasd";

        // Act & Assert
        new CurrencyPair(RUB_CODE, incorrectCode, RUB_TO_USD_RATE);
    }
}
