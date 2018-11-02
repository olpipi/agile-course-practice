package ru.unn.agile.ConverterTemperatures.model;

public class TempConverter {

    public TempConverter() {
    }
    public static double convert(double value, TempUnit tempUnit) {
        double coef = tempUnit.getCoef();
        double offset = tempUnit.getOffset();
        double result;

        result = coef * value + offset;

        return result;
    }

    /**private LengthConverter() {
     }
     public static double convert(final LengthUnit sourceUnit,
     final double value,
     final LengthUnit targetUnit) {
     return value * sourceUnit.getUnitToMeter() / targetUnit.getUnitToMeter();
     }*/
}
