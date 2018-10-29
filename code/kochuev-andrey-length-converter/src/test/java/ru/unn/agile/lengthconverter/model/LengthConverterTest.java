package ru.unn.agile.lengthconverter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthConverterTest {
    private static final double EPSILON = 0.000001;

    @Test
    public void canConvertMetersToMillimeters() {
        LengthConverter converter = new LengthConverter();
        double convertedValue = converter.convertMetersToMillimeters(5);
        assertEquals(5000, convertedValue,EPSILON);
    }

    @Test
    public void canConvertMillimetersToMeters() {
        LengthConverter converter = new LengthConverter();
        double convertedValue = converter.convertMillimetersToMeters(5);
        assertEquals(0.005, convertedValue, EPSILON);
    }
}
