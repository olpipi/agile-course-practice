package ru.unn.agile.stringcalculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void canReturnZeroForEmptyString()
    {
        int sum = StringCalculator.Add("");

        assertEquals(sum ,0);
    }

    @Test
    public void canAddSingleNumber()
    {
        int sum = StringCalculator.Add("1");

        assertEquals(sum ,1);
    }

}
