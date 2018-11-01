package ru.unn.agile.ConverterTemperatures.Model;

import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.ConverterTemperatures;
import ru.unn.agile.ConverterTemperatures.model.ConverterWithFahrenheit;
import ru.unn.agile.ConverterTemperatures.model.ConverterWithKelvin;
import static org.junit.Assert.assertEquals;

public class ConverterTemperaturesTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canConvertZeroToFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempCelsius = 0.0;
        double expectedTempFahrenheit = 32.0;

        double calculatingTempFahrenheit = converter.convertTo(tempCelsius);

        assertEquals(expectedTempFahrenheit, calculatingTempFahrenheit, EPSILON);
    }

    @Test
    public void canConvert100ToFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempCelsius = 100.0;
        double expectedTempFahrenheit = 212.0;

        double calculatingTempFahrenheit = converter.convertTo(tempCelsius);

        assertEquals(expectedTempFahrenheit, calculatingTempFahrenheit, EPSILON);
    }

    @Test
    public void canConvertZeroFromFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempFahrenheit = 0.0;
        double expectedTempCelsius = -17.777778;

        double calculatingTempCelsius = converter.convertFromCelsius(tempFahrenheit);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

    @Test
    public void canConvert100FromFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempFahrenheit = 100.0;
        double expectedTempCelsius = 37.777778;

        double calculatingTempCelsius = converter.convertFromCelsius(tempFahrenheit);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

    @Test
    public void canConvertZeroToKelvin() {
        ConverterTemperatures converter = new ConverterWithKelvin();
        double tempCelsius = 0.0;
        double expectedTempKelvin = 273.15;

        double calculatingTempKelvin = converter.convertTo(tempCelsius);

        assertEquals(expectedTempKelvin, calculatingTempKelvin, EPSILON);
    }
    @Test
    public void canConvert100ToKelvin() {
        ConverterTemperatures converter = new ConverterWithKelvin();
        double tempCelsius = 100.0;
        double expectedTempKelvin = 373.15;

        double calculatingTempKelvin = converter.convertTo(tempCelsius);

        assertEquals(expectedTempKelvin, calculatingTempKelvin, EPSILON);
    }

}
