package ru.unn.agile.calculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public final class CalculatorTest {
    @Test
    public void canAddTwoAndTwoBinary() {
        String n1 = "b10";
        String n2 = "b10";

        String expected = "b100";
        String result = Calculator.add(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canAddThreeAndTwoBinary() {
        String n1 = "b11";
        String n2 = "b10";

        String expected = "b101";
        String result = Calculator.add(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canAddTwoAndTwoOctalToBinary() {
        String n1 = "o2";
        String n2 = "o2";

        String expected = "b100";
        String result = Calculator.add(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canAddInDifferentSystems() {
        String n1 = "x10";
        String n2 = "b1111";

        String expected = "o37";
        String result = Calculator.add(n1, n2, NumberSystem.OCTAL);

        assertEquals(expected, result);
    }

    @Test
    public void checkCommutativityOfAddiction() {
        String n1 = "x10";
        String n2 = "b1111";

        String x = Calculator.add(n1, n2, NumberSystem.OCTAL);
        String y = Calculator.add(n2, n1, NumberSystem.OCTAL);

        assertEquals(x, y);
    }

    @Test
    public void checkAssociativityOfAddiction() {
        String n1 = "x10";
        String n2 = "b1111";
        String n3 = "o12";

        String x = Calculator.add(
                (Calculator.add(n1, n2, NumberSystem.BINARY)), n3, NumberSystem.OCTAL);
        String y = Calculator.add(
                n1, (Calculator.add(n2, n3, NumberSystem.BINARY)), NumberSystem.OCTAL);

        assertEquals(x, y);
    }

    @Test
    public void canMultiplyTwoAndTwoBinary() {
        String n1 = "b10";
        String n2 = "b10";

        String expected = "b100";
        String result = Calculator.multiply(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canMultiplyThreeAndTwoBinary() {
        String n1 = "b11";
        String n2 = "b10";

        String expected = "b110";
        String result = Calculator.multiply(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canMultiplyTwoAndTwoOctalToBinary() {
        String n1 = "o2";
        String n2 = "o2";

        String expected = "b100";
        String result = Calculator.multiply(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void checkCommutativityOfMultiplication() {
        String n1 = "x10";
        String n2 = "b1111";

        String x = Calculator.multiply(n1, n2, NumberSystem.OCTAL);
        String y = Calculator.multiply(n2, n1, NumberSystem.OCTAL);

        assertEquals(x, y);
    }

    @Test
    public void checkAssociativityOfMultiplication() {
        String n1 = "x10";
        String n2 = "b1111";
        String n3 = "o12";

        String x = Calculator.multiply(
                (Calculator.multiply(n1, n2, NumberSystem.BINARY)), n3, NumberSystem.OCTAL);
        String y = Calculator.multiply(
                n1, (Calculator.multiply(n2, n3, NumberSystem.BINARY)), NumberSystem.OCTAL);

        assertEquals(x, y);
    }

    @Test
    public void canUnaryMinusTwoBinary() {
        String number = "b10";

        String expected = "b-10";
        String result = Calculator.unaryMinus(number, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canMultiplyNegative() {
        String n1 = "x-10";
        String n2 = "b-1111";

        String expected = "o360";
        String result = Calculator.multiply(n1, n2, NumberSystem.OCTAL);

        assertEquals(expected, result);
    }

    @Test
    public void canUnaryMinusThreeBinary() {
        String number = "b11";

        String expected = "b-11";
        String result = Calculator.unaryMinus(number, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canUnaryMinusZeroHexadecimal() {
        String number = "x-0";

        String expected = "o0";
        String result = Calculator.unaryMinus(number, NumberSystem.OCTAL);

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotAddWithInvalidArgument() {
        String n1 = "10";
        String n2 = "b1111";
        Calculator.add(n1, n2, NumberSystem.OCTAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotMultiplyWithInvalidArgument() {
        String n1 = "10";
        String n2 = "b1111";
        Calculator.multiply(n1, n2, NumberSystem.OCTAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotUnaryMinusInvalidArgument() {
        String number = "10";
        Calculator.unaryMinus(number, NumberSystem.OCTAL);
    }
}
