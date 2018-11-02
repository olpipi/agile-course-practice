package ru.unn.agile.ConverterTemperatures.model;

public final class ConverterWithNewton implements ConverterTemperatures {
    private double result;

    public double getResult() {

        return result;
    }
    @Override
    public double convertFromCelsius(final double tempCelsius) {
        final double coef = 33.0 / 100.0;

        result = tempCelsius * coef;

        return result;
    }
    @Override
    public double convertToCelsius(final double tempSomeUnit) {
        final double coef = 100.0 /  33.0;

        result = tempSomeUnit * coef;

        return result;
    }
}
