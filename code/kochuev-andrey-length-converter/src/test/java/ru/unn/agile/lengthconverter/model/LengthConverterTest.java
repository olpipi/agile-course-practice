package ru.unn.agile.lengthconverter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthConverterTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canConvertMetersToMillimeters() {
        double convertedValue = LengthUnit.METERS.convert(5, LengthUnit.MILLIMETERS);
        assertEquals(5000, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMillimetersToMeters() {
        double convertedValue = LengthUnit.MILLIMETERS.convert(5, LengthUnit.METERS);
        assertEquals(0.005, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMetersToKilometers() {
        double convertedValue = LengthUnit.METERS.convert(5, LengthUnit.KILOMETERS);
        assertEquals(0.005, convertedValue, EPSILON);
    }

    @Test
    public void canConvertKilometersToMeters() {
        double convertedValue = LengthUnit.KILOMETERS.convert(5, LengthUnit.METERS);
        assertEquals(5000, convertedValue, EPSILON);
    }
}
