package ru.unn.agile.ConverterTemperatures.model;

public interface ConverterTemperatures {
    public double getResult();
    double convertFromCelsius(double tempCelsius);
    double convertToCelsius(double tempSomeUnit);
}
