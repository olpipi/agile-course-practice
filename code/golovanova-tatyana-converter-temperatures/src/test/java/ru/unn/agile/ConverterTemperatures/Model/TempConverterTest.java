package ru.unn.agile.ConverterTemperatures.Model;

import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.TempConverter;
import ru.unn.agile.ConverterTemperatures.model.TempUnit;
import ru.unn.agile.ConverterTemperatures.model.TempConverterExceptions;

import static org.junit.Assert.assertEquals;

public class TempConverterTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canConvertZeroToFahrenheit() {
        TempConverter converter = new TempConverter();
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double tempBefore = 0.0;
        double expectedTempAfter = 32.0;

        double calculatingTempAfter = converter.convert(tempBefore,tempUnit);

        assertEquals(expectedTempAfter, calculatingTempAfter, EPSILON);
    }

    @Test
    public void canConvert100ToFahrenheit() {
        TempConverter converter = new TempConverter();
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double tempBefore = 100.0;
        double expectedTempAfter = 212;

        double calculatingTempAfter = converter.convert(tempBefore,tempUnit);

        assertEquals(expectedTempAfter, calculatingTempAfter, EPSILON);
    }

    @Test (expected = TempConverterExceptions.class)
    public void canConvertAbsMinToFahrenheit() {
        TempConverter converter = new TempConverter();
        TempUnit tempUnit = TempUnit.FAHRENHEIT;
        double tempBefore = -273.16;

        double calculatingTempAfter = converter.convert(tempBefore,tempUnit);
    }
}
