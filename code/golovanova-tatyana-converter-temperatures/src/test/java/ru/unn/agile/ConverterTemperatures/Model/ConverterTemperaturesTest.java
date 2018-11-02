package ru.unn.agile.ConverterTemperatures.Model;

import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.ConverterTemperatures;
import ru.unn.agile.ConverterTemperatures.model.ConverterWithFahrenheit;
import ru.unn.agile.ConverterTemperatures.model.ConverterWithKelvin;
import ru.unn.agile.ConverterTemperatures.model.ConverterWithNewton;
import static org.junit.Assert.assertEquals;

public class ConverterTemperaturesTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canConvertZeroToFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempCelsius = 0.0;
        double expectedTempFahrenheit = 32.0;

        double calculatingTempFahrenheit = converter.convertFromCelsius(tempCelsius);

        assertEquals(expectedTempFahrenheit, calculatingTempFahrenheit, EPSILON);
    }

    @Test
    public void canConvert100ToFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempCelsius = 100.0;
        double expectedTempFahrenheit = 212.0;

        double calculatingTempFahrenheit = converter.convertFromCelsius(tempCelsius);

        assertEquals(expectedTempFahrenheit, calculatingTempFahrenheit, EPSILON);
    }

    @Test
    public void canConvertZeroFromFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempFahrenheit = 0.0;
        double expectedTempCelsius = -17.777778;

        double calculatingTempCelsius = converter.convertToCelsius(tempFahrenheit);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

    @Test
    public void canConvert100FromFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempFahrenheit = 100.0;
        double expectedTempCelsius = 37.777778;

        double calculatingTempCelsius = converter.convertToCelsius(tempFahrenheit);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

    @Test
    public void canGetResultWithFahrenheit() {
        ConverterTemperatures converter = new ConverterWithFahrenheit();
        double tempFahrenheit = 100.0;
        double expectedTempCelsius = 37.777778;

        converter.convertToCelsius(tempFahrenheit);
        double getTempCelsiusAfterCalculating = converter.getResult();

        assertEquals(expectedTempCelsius, getTempCelsiusAfterCalculating, EPSILON);
    }

    @Test
    public void canConvertZeroToKelvin() {
        ConverterTemperatures converter = new ConverterWithKelvin();
        double tempCelsius = 0.0;
        double expectedTempKelvin = 273.15;

        double calculatingTempKelvin = converter.convertFromCelsius(tempCelsius);

        assertEquals(expectedTempKelvin, calculatingTempKelvin, EPSILON);
    }

    @Test
    public void canConvert100ToKelvin() {
        ConverterTemperatures converter = new ConverterWithKelvin();
        double tempCelsius = 100.0;
        double expectedTempKelvin = 373.15;

        double calculatingTempKelvin = converter.convertFromCelsius(tempCelsius);

        assertEquals(expectedTempKelvin, calculatingTempKelvin, EPSILON);
    }

    @Test
    public void canConvertZeroFromKelvin() {
        ConverterTemperatures converter = new ConverterWithKelvin();
        double tempKelvin = 0.0;
        double expectedTempCelsius = -273.15;

        double calculatingTempCelsius = converter.convertToCelsius(tempKelvin);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

    @Test
    public void canConvert100FromKelvin() {
        ConverterTemperatures converter = new ConverterWithKelvin();
        double tempKelvin = 100.0;
        double expectedTempCelsius = -173.15;

        double calculatingTempCelsius = converter.convertToCelsius(tempKelvin);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }


    @Test
    public void canConvertZeroToNewton() {
        ConverterTemperatures converter = new ConverterWithNewton();
        double tempCelsius = 0.0;
        double expectedTempKelvin = 0.0;

        double calculatingTempKelvin = converter.convertFromCelsius(tempCelsius);

        assertEquals(expectedTempKelvin, calculatingTempKelvin, EPSILON);
    }

    @Test
    public void canConvert100ToNewton() {
        ConverterTemperatures converter = new ConverterWithNewton();
        double tempCelsius = 100.0;
        double expectedTempKelvin = 33.0;

        double calculatingTempKelvin = converter.convertFromCelsius(tempCelsius);

        assertEquals(expectedTempKelvin, calculatingTempKelvin, EPSILON);
    }

    @Test
    public void canConvert0FromNewton() {
        ConverterTemperatures converter = new ConverterWithNewton();
        double tempNewton = 0.0;
        double expectedTempCelsius = 0.0;

        double calculatingTempCelsius = converter.convertToCelsius(tempNewton);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

    @Test
    public void canConvert100FromNewton() {
        ConverterTemperatures converter = new ConverterWithNewton();
        double tempNewton = 100.0;
        double expectedTempCelsius = 303.030303;

        double calculatingTempCelsius = converter.convertToCelsius(tempNewton);

        assertEquals(expectedTempCelsius, calculatingTempCelsius, EPSILON);
    }

}
