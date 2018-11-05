package ru.unn.agile.ConverterTemperatures.Model;

import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.TempConverter;
import ru.unn.agile.ConverterTemperatures.model.TempUnit;
import ru.unn.agile.ConverterTemperatures.model.TempConverterExceptions;

import static org.junit.Assert.assertEquals;

public class TempConverterTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canGetCoefForFahrenheit() {
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double coefExpected = 1.8;

        double coefActual = tempUnit.getCoef();

        assertEquals(coefExpected, coefActual, EPSILON);
    }

    @Test
    public void canGetOffsetForFahrenheit() {
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double offsetExpected = 32;

        double offsetActual = tempUnit.getOffset();

        assertEquals(offsetExpected, offsetActual, EPSILON);
    }

    @Test
    public void canConvertZeroToFahrenheit() {
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double tempBefore = 0.0;
        double expectedTempAfter = 32.0;

        double calculatingTempAfter = TempConverter.convert(tempBefore, tempUnit);

        assertEquals(expectedTempAfter, calculatingTempAfter, EPSILON);
    }

    @Test
    public void canConvert100ToFahrenheit() {
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double tempBefore = 100.0;
        double expectedTempAfter = 212;

        double calculatingTempAfter = TempConverter.convert(tempBefore, tempUnit);

        assertEquals(expectedTempAfter, calculatingTempAfter, EPSILON);
    }

    @Test (expected = TempConverterExceptions.class)
    public void canConvertAbsMinToFahrenheit() {
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double tempBefore = -273.16;

        double calculatingTempAfter = TempConverter.convert(tempBefore, tempUnit);
    }

    @Test
    public void canGetCoefForKelvin() {
        TempUnit tempUnit = TempUnit.KELVIN;
        double coefExpected = 1;

        double coefActual = tempUnit.getCoef();

        assertEquals(coefExpected, coefActual, EPSILON);
    }

    @Test
    public void canGetOffsetForKelvin() {
        TempUnit tempUnit = TempUnit.KELVIN;
        double offsetExpected = 273.15;

        double offsetActual = tempUnit.getOffset();

        assertEquals(offsetExpected, offsetActual, EPSILON);
    }


}
