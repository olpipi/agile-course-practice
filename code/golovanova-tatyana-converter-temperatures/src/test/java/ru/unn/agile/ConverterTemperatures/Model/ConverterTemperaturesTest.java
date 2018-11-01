package ru.unn.agile.ConverterTemperatures.Model;

import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.ConverterTemperatures;
import ru.unn.agile.ConverterTemperatures.model.ConverterToFahrenheit;

import static org.junit.Assert.assertEquals;

public class ConverterTemperaturesTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canConvertZeroToFahrenheit() {
        ConverterTemperatures converter = new ConverterToFahrenheit();
        double tempCelsius = 0.0;
        double expectedTempFahrenheit = 32.0;

        double calculatingTempFahrenheit = converter.convert(tempCelsius);

        assertEquals(expectedTempFahrenheit, calculatingTempFahrenheit, EPSILON);
    }

    @Test
    public void canConvert_100_ToFahrenheit() {
        ConverterTemperatures converter = new ConverterToFahrenheit();
        double tempCelsius = 100.0;
        double expectedTempFahrenheit = 212.0;

        double calculatingTempFahrenheit = converter.convert(tempCelsius);

        assertEquals(expectedTempFahrenheit, calculatingTempFahrenheit, EPSILON);
    }
}
