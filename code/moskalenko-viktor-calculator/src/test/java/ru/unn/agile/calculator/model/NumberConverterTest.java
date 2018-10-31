package ru.unn.agile.calculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberConverterTest {
    @Test
    public void canParseZeroFromBinary() {
        NumberConverter converter = new NumberConverter();

        int expected = 0;
        int result = converter.parse("0b0");

        assertEquals(expected, result);
    }

    @Test
    public void canParseOneFromBinary() {
        NumberConverter converter = new NumberConverter();

        int expected = 1;
        int result = converter.parse("0b1");

        assertEquals(expected, result);
    }


    @Test
    public void canParseTwoFromBinary() {
        NumberConverter converter = new NumberConverter();

        int expected = 2;
        int result = converter.parse("0b10");

        assertEquals(expected, result);
    }
}
