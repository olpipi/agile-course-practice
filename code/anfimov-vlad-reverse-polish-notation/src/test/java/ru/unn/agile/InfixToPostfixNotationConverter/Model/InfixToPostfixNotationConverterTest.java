package ru.unn.agile.InfixToPostfixNotationConverter.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfixToPostfixNotationConverterTest {

    @Test(expected = RuntimeException.class)
    public void conversionThrowsWhenInputIsEmpty() {
        InfixToPostfixNotationConverter.convert("");
    }

    @Test(expected = RuntimeException.class)
    public void conversionThrowsWhenInputWhiteSpace() {
        InfixToPostfixNotationConverter.convert("  ");
    }

    @Test(expected = RuntimeException.class)
    public void conversionThrowsWhenInputTwoTokensInRow() {
        InfixToPostfixNotationConverter.convert("4++");
    }

    @Test
    public void canConvertSimpleExpression() {
        String result = InfixToPostfixNotationConverter.convert("4 + 3 * 2");
        String expected = "432*+";

        assertEquals(expected, result);
    }

    @Test
    public void canConvertExpressionWithBrackets() {
        String result = InfixToPostfixNotationConverter.convert("((5 / (7 - (1 + 1))) * 5) - 2");
        String expected = "5711+-/5*2-";

        assertEquals(expected, result);
    }

    @Test
    public void canAddTwoNumbers() {
        int result = InfixToPostfixNotationConverter.calculateResult("4 + 3");

        assertEquals(7, result);
    }

    @Test
    public void canCalculateResultWithBrackets() {
        int result = InfixToPostfixNotationConverter.calculateResult("(4 + 3)*2");

        assertEquals(14, result);
    }


    @Test
    public void canCalculateHardExpression() {
        String input = "((5 / (7 - (1 + 1))) * 5) - (2 + (1 + 1))";
        int result = InfixToPostfixNotationConverter.calculateResult(input);

        assertEquals(1, result);
    }
}
