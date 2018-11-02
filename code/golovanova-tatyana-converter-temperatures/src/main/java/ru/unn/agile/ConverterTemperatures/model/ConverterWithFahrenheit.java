package ru.unn.agile.ConverterTemperatures.model;

public final class ConverterWithFahrenheit implements ConverterTemperatures {

    private double result;

    public double getResult() {
        return result;
    }
    @Override
    public double convertFromCelsius(final double tempCelsius) {
        final double coef1 = 9.0 / 5.0;
        final double coef2 = 32.0;

        result = tempCelsius * coef1  + coef2;

        return result;
    }
    @Override
    public double convertToCelsius(final double tempSomeUnit) {
        final double coef1 = 5.0 / 9.0;
        final double coef2 = 32.0;

        result = (tempSomeUnit - coef2) * coef1;

        return result;
    }
}
