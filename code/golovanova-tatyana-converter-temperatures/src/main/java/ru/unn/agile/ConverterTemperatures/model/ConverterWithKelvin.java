package ru.unn.agile.ConverterTemperatures.model;

public final class ConverterWithKelvin implements ConverterTemperatures {

    private double result;

    public double getResult() {

        return result;
    }
    @Override
    public double convertFromCelsius(final double tempCelsius) {
        final double coef = 273.15;

        result = tempCelsius + coef;

        return result;
    }
    @Override
    public double convertToCelsius(final double tempSomeUnit) {
        final double coef = 273.15;

        result = tempSomeUnit - coef;
        return result;
    }
}
