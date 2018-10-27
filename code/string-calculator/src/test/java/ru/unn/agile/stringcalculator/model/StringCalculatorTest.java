package ru.unn.agile.stringcalculator.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void canReturnZeroForEmptyString() {
        int sum = StringCalculator.Add("");

        assertEquals(0 ,sum);
    }

    @Test
    public void canAddSingleNumber() {
        int sum = StringCalculator.Add("1");

        assertEquals(1 ,sum);
    }

    @Test
    public void canAddTwoNumbers() {
        int sum = StringCalculator.Add("1,2");

        assertEquals(3, sum);
    }

    @Test
    public void canAddThreeNumbers() {
        int sum = StringCalculator.Add("1,2,3");

        assertEquals(6, sum);
    }

    @Test
    public void canAddNewLineSeparatedNumbers() {
        int sum = StringCalculator.Add("1\n2");

        assertEquals(3, sum);
    }

    @Test
    public void canAddThreeNewLineSeparatedNumbers() {
        int sum = StringCalculator.Add("1\n2\n3");

        assertEquals(6, sum);
    }

    @Test
    public void canAddNumbersWithDifferentDelimiters(){
        int sum = StringCalculator.Add("1,2\n3");

        assertEquals(6, sum);
    }

    @Test
    public void canAddNumbersWithTrailingDelimiterAtTheEnd(){
        int sum = StringCalculator.Add("1,2,");

        assertEquals(3, sum);
    }

    @Test
    public void canAddNumbersWithTrailingNewLineAtTheEnd(){
        int sum = StringCalculator.Add("1,2\n");

        assertEquals(3, sum);
    }

}
