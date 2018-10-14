package ru.unn.agile.currencyconverter.model;

public class CurrencyConverter {
    private static final double RUB_TO_USD_RATE = 0.015;

    public double convertRubToUsd(final double rublesAmount) {
        return rublesAmount * RUB_TO_USD_RATE;
    }
}
