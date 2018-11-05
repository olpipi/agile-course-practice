package ru.unn.agile.ConverterTemperatures.model;

public class TempConverter {
    private static final double ABS_MIN_TEMP = -273.15;

    public TempConverter() {
    }
    public static double convert(double value, TempUnit tempUnit) {
        if (value < ABS_MIN_TEMP){
            throw new TempConverterExceptions("Value less more absolute minimun temperature");
        }
        else {
            double coef = tempUnit.getCoef();
            double offset = tempUnit.getOffset();
            double result;

            result = coef * value + offset;

            return result;
        }
    }
}
