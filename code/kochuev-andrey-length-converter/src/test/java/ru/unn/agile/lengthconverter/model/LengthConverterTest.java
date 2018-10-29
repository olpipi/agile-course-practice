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
    public void canConvertMetersToKilometers() {
        double convertedValue = LengthUnit.METERS.convert(5, LengthUnit.KILOMETERS);
        assertEquals(0.005, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMetersToMeters() {
        double convertedValue = LengthUnit.METERS.convert(5, LengthUnit.METERS);
        assertEquals(5, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMetersToFeet() {
        double convertedValue = LengthUnit.METERS.convert(5, LengthUnit.FEET);
        assertEquals(16.4042, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMillimetersToMeters() {
        double convertedValue = LengthUnit.MILLIMETERS.convert(5, LengthUnit.METERS);
        assertEquals(0.005, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMillimetersToKilometers() {
        double convertedValue = LengthUnit.MILLIMETERS.convert(5, LengthUnit.KILOMETERS);
        assertEquals(0.000005, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMillimetersToFeet() {
        double convertedValue = LengthUnit.MILLIMETERS.convert(5, LengthUnit.FEET);
        assertEquals(0.0164042, convertedValue, EPSILON);
    }

    @Test
    public void canConvertMillimetersToMillimeters() {
        double convertedValue = LengthUnit.MILLIMETERS.convert(5, LengthUnit.MILLIMETERS);
        assertEquals(5, convertedValue, EPSILON);
    }

    @Test
    public void canConvertKilometersToMeters() {
        double convertedValue = LengthUnit.KILOMETERS.convert(5, LengthUnit.METERS);
        assertEquals(5000, convertedValue, EPSILON);
    }

    @Test
    public void canConvertKilometersToMillimeters() {
        double convertedValue = LengthUnit.KILOMETERS.convert(5, LengthUnit.MILLIMETERS);
        assertEquals(5000000, convertedValue, EPSILON);
    }

    @Test
    public void canConvertKilometersToFeet() {
        double convertedValue = LengthUnit.KILOMETERS.convert(5, LengthUnit.FEET);
        assertEquals(16404.2, convertedValue, EPSILON);
    }

    @Test
    public void canConvertKilometersToKilometers() {
        double convertedValue = LengthUnit.KILOMETERS.convert(5, LengthUnit.KILOMETERS);
        assertEquals(5, convertedValue, EPSILON);
    }

    @Test
    public void canConvertFeetToMeters() {
        double convertedValue = LengthUnit.FEET.convert(5, LengthUnit.METERS);
        assertEquals(1.524, convertedValue, EPSILON);
    }

    @Test
    public void canConvertFeetToMillimeters() {
        double convertedValue = LengthUnit.FEET.convert(5, LengthUnit.MILLIMETERS);
        assertEquals(1524, convertedValue, EPSILON);
    }

    @Test
    public void canConvertFeetToKilometers() {
        double convertedValue = LengthUnit.FEET.convert(5, LengthUnit.KILOMETERS);
        assertEquals(0.001524, convertedValue, EPSILON);
    }

    @Test
    public void canConvertFeetToFeet() {
        double convertedValue = LengthUnit.FEET.convert(5, LengthUnit.FEET);
        assertEquals(5, convertedValue, EPSILON);
    }
}
