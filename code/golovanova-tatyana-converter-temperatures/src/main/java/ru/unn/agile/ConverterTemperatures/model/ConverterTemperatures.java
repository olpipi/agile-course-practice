package ru.unn.agile.ConverterTemperatures.model;

public interface ConverterTemperatures {
    double convertTo(double tempCelsius);
    double convertFromCelsius(double tempSomeUnit);
}
