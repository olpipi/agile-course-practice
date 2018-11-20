package ru.unn.agile.calculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberConverterTest {
    @Test
    public void canParseZeroFromBinary() {
        int expected = 0;
        int result = NumberConverter.parse("b0");
        assertEquals(expected, result);
    }

    @Test
    public void canParseOneFromBinary() {
        int expected = 1;
        int result = NumberConverter.parse("b1");
        assertEquals(expected, result);
    }


    @Test
    public void canParseTwoFromBinary() {
        int expected = 2;
        int result = NumberConverter.parse("b10");
        assertEquals(expected, result);
    }

    @Test
    public void canParseZeroFromOctal() {
        int expected = 0;
        int result = NumberConverter.parse("o0");
        assertEquals(expected, result);
    }

    @Test
    public void canParseOneFromOctal() {
        int expected = 1;
        int result = NumberConverter.parse("o1");
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseEmptyNumber() {
        NumberConverter.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseFromInvalidBinaryNumber() {
        NumberConverter.parse("oba");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseFromInvalidOctalNumber() {
        NumberConverter.parse("oba");
    }

    @Test
    public void canParseTenFromHexadecimalNumber() {
        int expected = 10;
        int result = NumberConverter.parse("xa");
        assertEquals(expected, result);
    }

    @Test
    public void checkTryParseFiveFromBinary() {
        Integer expected = 5;
        Integer result = NumberConverter.tryParse("b101");
        assertEquals(expected, result);
    }

    @Test
    public void checkTryParseNoException() {
        Integer result = NumberConverter.tryParse("b1021");
        assertNull(result);
    }

    @Test
    public void canParseMinIntValue() {
        int expected = Integer.MIN_VALUE;
        int result = NumberConverter.parse("x-80000000");
        assertEquals(expected, result);
    }

    @Test
    public void canParseMaxIntValue() {
        int expected = Integer.MAX_VALUE;
        int result = NumberConverter.parse("x7fffffff");
        assertEquals(expected, result);
    }

    @Test (expected = NumberFormatException.class)
    public void checkIntegerOverflow() {
        NumberConverter.parse("x80000000");
    }

    @Test
    public void canConvertFiveToBinary() {
        String expected = "b101";
        String result = NumberConverter.format(5, NumberSystem.BINARY);
        assertEquals(expected, result);
    }

    @Test
    public void canConverEightToBinary() {
        String expected = "b1000";
        String result = NumberConverter.format(8, NumberSystem.BINARY);
        assertEquals(expected, result);
    }

    @Test
    public void canConvertFiveToOctal() {
        String expected = "o5";
        String result = NumberConverter.format(5, NumberSystem.OCTAL);
        assertEquals(expected, result);
    }

    @Test
    public void canConvertTwelveToHexadecimal() {
        String expected = "xc";
        String result = NumberConverter.format(12, NumberSystem.HEXADECIMAL);
        assertEquals(expected, result);
    }

    @Test
    public void canConvertMaxIntToHexadecimal() {
        String expected = "x7fffffff";
        String result = NumberConverter.format(Integer.MAX_VALUE, NumberSystem.HEXADECIMAL);
        assertEquals(expected, result);
    }

    @Test
    public void canParseNegative() {
        int expected = -10;
        int result = NumberConverter.parse("b-1010");
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotFormatUnknownNumberSystem() {
        NumberConverter.format(5, NumberSystem.UNKNOWN);
    }
}
