package ru.unn.agile.calculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberConverterTest {
    @Test
    public void canParseZeroFromBinary() {
        int expected = 0;
        int result = NumberConverter.parse("0b0");
        assertEquals(expected, result);
    }

    @Test
    public void canParseOneFromBinary() {
        int expected = 1;
        int result = NumberConverter.parse("0b1");
        assertEquals(expected, result);
    }


    @Test
    public void canParseTwoFromBinary() {
        int expected = 2;
        int result = NumberConverter.parse("0b10");
        assertEquals(expected, result);
    }

    @Test
    public void canParseZeroFromOctal() {
        int expected = 0;
        int result = NumberConverter.parse("00");
        assertEquals(expected, result);
    }

    @Test
    public void canParseOneFromOctal() {
        int expected = 1;
        int result = NumberConverter.parse("01");
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseEmptyNumber() {
        NumberConverter.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseFromInvalidBinaryNumber() {
        NumberConverter.parse("0ba");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseFromInvalidOctalNumber() {
        NumberConverter.parse("0ba");
    }

    @Test
    public void canParseTenFromHexadecimalNumber() {
        int expected = 10;
        int result = NumberConverter.parse("0xa");
        assertEquals(expected, result);
    }

    @Test
    public void checkTryParseFiveFromBinary() {
        Integer expected = 5;
        Integer result = NumberConverter.tryParse("0b101");
        assertEquals(expected, result);
    }

    @Test
    public void checkTryParseNoException() {
        Integer result = NumberConverter.tryParse("0b1021");
        assertNull(result);
    }

    @Test
    public void canParseMinIntValue() {
        int expected = Integer.MIN_VALUE;
        int result = NumberConverter.parse("-0x80000000");
        assertEquals(expected, result);
    }

    @Test
    public void canParseMaxIntValue() {
        int expected = Integer.MAX_VALUE;
        int result = NumberConverter.parse("0x7fffffff");
        assertEquals(expected, result);
    }

    @Test (expected = NumberFormatException.class)
    public void checkIntegerOverflow() {
        NumberConverter.parse("0x80000000");
    }

    @Test
    public void canConvertFiveToBinary() {
        String expected = "0b101";
        String result = NumberConverter.convert(5, NumberSystem.BINARY);
        assertEquals(expected, result);
    }

    @Test
    public void canConverEightToBinary() {
        String expected = "0b1000";
        String result = NumberConverter.convert(8, NumberSystem.BINARY);
        assertEquals(expected, result);
    }

    @Test
    public void canConvertFiveToOctal() {
        String expected = "05";
        String result = NumberConverter.convert(5, NumberSystem.OCTAL);
        assertEquals(expected, result);
    }

    @Test
    public void canConvertTwelveToHexadecimal() {
        String expected = "0xc";
        String result = NumberConverter.convert(12, NumberSystem.HEXADECIMAL);
        assertEquals(expected, result);
    }

    @Test
    public void canConvertMaxIntToHexadecimal() {
        String expected = "0x7fffffff";
        String result = NumberConverter.convert(Integer.MAX_VALUE, NumberSystem.HEXADECIMAL);
        assertEquals(expected, result);
    }
}
