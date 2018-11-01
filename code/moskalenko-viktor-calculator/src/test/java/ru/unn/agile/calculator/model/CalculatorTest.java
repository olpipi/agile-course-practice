package ru.unn.agile.calculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public final class CalculatorTest {
    @Test
    public void canAddTwoAndTwoBinary() {
        String n1 = "0b10";
        String n2 = "0b10";

        String expected = "0b100";
        String result = Calculator.add(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canAddThreeAndTwoBinary() {
        String n1 = "0b11";
        String n2 = "0b10";

        String expected = "0b101";
        String result = Calculator.add(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canAddTwoAndTwoOctalToBinary() {
        String n1 = "02";
        String n2 = "02";

        String expected = "0b100";
        String result = Calculator.add(n1, n2, NumberSystem.BINARY);

        assertEquals(expected, result);
    }

    @Test
    public void canAddInDifferentSystems() {
        String n1 = "0x10";
        String n2 = "0b1111";

        String expected = "037";
        String result = Calculator.add(n1, n2, NumberSystem.OCTAL);

        assertEquals(expected, result);
    }

    @Test
    public void checkCommutativityOfAddiction() {
        String n1 = "0x10";
        String n2 = "0b1111";

        String x = Calculator.add(n1, n2, NumberSystem.OCTAL);
        String y = Calculator.add(n2, n1, NumberSystem.OCTAL);

        assertEquals(x, y);
    }

    @Test
    public void checkAssociativityOfAddiction() {
        String n1 = "0x10";
        String n2 = "0b1111";
        String n3 = "012";

        String x = Calculator.add((Calculator.add(n1, n2, NumberSystem.BINARY)), n3, NumberSystem.OCTAL);
        String y = Calculator.add(n1, (Calculator.add(n2, n3, NumberSystem.BINARY)), NumberSystem.OCTAL);

        assertEquals(x, y);
    }
}
