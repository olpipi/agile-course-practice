package ru.unn.agile.ConverterTemperatures.model;

public interface ConverterTemperatures {
    double getResult();
    double convertFromCelsius(double tempCelsius);
    double convertToCelsius(double tempSomeUnit);
}
