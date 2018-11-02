package ru.unn.agile.ConverterTemperatures.model;

public enum  TempUnit {
    FAHRENHEIT(1.8, 32);

    private final double coef;
    private final double offset;
    TempUnit (final double coef, final double offset) {
        this.coef = coef;
        this.offset = offset;
    }
    public double getCoef(){
        return coef;
    }
    public double getOffset(){
        return offset;
    }
}
