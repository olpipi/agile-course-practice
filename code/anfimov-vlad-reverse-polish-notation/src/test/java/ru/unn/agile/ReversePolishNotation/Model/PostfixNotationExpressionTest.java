package ru.unn.agile.ReversePolishNotation.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostfixNotationExpressionTest {

    @Test
    public void createObject() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        assertNotNull(expression);
    }

    @Test(expected = RuntimeException.class)
    public void inputEmptyString() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        expression.convertToPostfixNotation("");
    }

    @Test(expected = RuntimeException.class)
    public void inputStringContainsFromWhiteSpace() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        expression.convertToPostfixNotation("  ");
    }

    @Test
    public void canConvertSimpleExpression() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        String[] str = expression.convertToPostfixNotation("4 + 3 * 2");
        String[] result = {"4", "3", "2", "*", "+"};

        assertArrayEquals(result, str);
    }

    @Test
    public void canConvertExpressionWithBrackets() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        String[] result = expression.convertToPostfixNotation("((5 / (7 - (1 + 1))) * 5) - 2");
        String[] a = {"5", "7", "1", "1", "+", "-", "/", "5", "*", "2", "-"};

        assertArrayEquals(a, result);
    }

    @Test
    public void canAdditionTwoNumbers() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        int result = expression.calculateResult("4 + 3");

        assertEquals(7, result);
    }

    @Test
    public void canCalculateResultWithBrackets() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        int result = expression.calculateResult("(4 + 3)*2");

        assertEquals(14, result);
    }


    @Test
    public void canHardExpressionCalculate() {
        PostfixNotationExpression expression = new PostfixNotationExpression();

        int result = expression.calculateResult("((5 / (7 - (1 + 1))) * 5) - (2 + (1 + 1))");

        assertEquals(1, result);
    }
}
