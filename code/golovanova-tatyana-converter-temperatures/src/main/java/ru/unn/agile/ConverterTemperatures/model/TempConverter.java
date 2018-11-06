package ru.unn.agile.ConverterTemperatures.model;

public final class TempConverter {
    private static final double ABS_MIN_TEMP = -273.15;

    private TempConverter() {
    }
    public static double convert(final double value, final TempUnit tempUnit) {
        if (value < ABS_MIN_TEMP) {
            throw new TempConverterExceptions("Value is less more absolute minimun temperature");
        } else {
            double coef = tempUnit.getCoef();
            double offset = tempUnit.getOffset();
            double result;

            result = coef * value + offset;

            return result;
        }
    }
}
