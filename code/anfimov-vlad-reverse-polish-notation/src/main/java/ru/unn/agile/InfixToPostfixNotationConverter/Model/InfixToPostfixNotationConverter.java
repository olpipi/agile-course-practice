package ru.unn.agile.InfixToPostfixNotationConverter.Model;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public final class InfixToPostfixNotationConverter {

    private static final String OPERATORS = "+-*/^";
    private static final String NUMBER_PATTERN = "^-?[0-9]+";
    private static final String INVALID_INPUT_PATTERN = "[*/+-]{2,}";
    private static final String EMPTY_STRING_PATTERN = "^\\s*$";
    private static final String BRACKET_LEFT = "(";
    private static final String BRACKET_RIGHT = ")";
    private static final String WHITESPACE_PATTERN = "\\s+";
    private static final String UNARY_SIGN = "-";

    private InfixToPostfixNotationConverter() { }

    private static int getPriority(final String operator) {
        switch (operator) {
            case "(":
            case ")":
                return 0;
            case "+":
            case "-":
                return 1;
            case "/":
            case "*":
                return 2;
            default:
                return -1;
        }
    }

    private static boolean isNumber(final String str) {
        return str.matches(NUMBER_PATTERN);
    }

    private static boolean isOperator(final String str) {
        return OPERATORS.contains(str);
    }

    private static boolean checkEmptyString(final String str) {
        return str.matches(EMPTY_STRING_PATTERN);
    }

    private static boolean checkValidInput(final String input) {
        boolean isEmptyString = checkEmptyString(input);

        long leftBracket = input.chars().filter(s -> s == '(').count();
        long rightBracket = input.chars().filter(s -> s == ')').count();

        boolean equalNumBracket = false;
        if (input.contains(BRACKET_LEFT) || input.contains(BRACKET_RIGHT)) {
            equalNumBracket = leftBracket != rightBracket;
        }

        Pattern pattern = Pattern.compile(INVALID_INPUT_PATTERN);
        Matcher matcher = pattern.matcher(input);

        return matcher.find() || equalNumBracket || isEmptyString;
    }

    private static String[] separation(final String input) {
        String[] result = input.replaceAll(WHITESPACE_PATTERN, "").split("");
        String output = "";
        for (int i = 0; i < result.length; i++) {
            if (isNumber(result[i])) {
                output += result[i];
            } else if (UNARY_SIGN.equals(result[i]) && (i == 0
                    || BRACKET_LEFT.equals(result[i - 1]))) {
                output += result[i];
            } else if (isOperator(result[i]) || BRACKET_LEFT.equals(result[i])
                    || BRACKET_RIGHT.equals(result[i])) {
                output += " ".concat(result[i]);
                output += " ";
            }
        }
        return output.split(WHITESPACE_PATTERN);
    }

    public static String[] convert(final String input) throws RuntimeException {
        if (checkValidInput(input)) {
            throw new RuntimeException("Wrong input!");
        }

        String[] expression = separation(input);

        String output = "";
        Stack<String> stack = new Stack<>();

        for (String str : expression) {
            if (BRACKET_LEFT.equals(str)) {
                stack.push(str);
            } else if (isNumber(str)) {
                output += str.concat(" ");
            } else if (BRACKET_RIGHT.equals(str)) {
                while (!stack.peek().equals(BRACKET_LEFT)) {
                    output += stack.pop().concat(" ");
                }
                stack.pop();
            } else if (isOperator(str)) {
                while (!stack.isEmpty() && getPriority(str) <= getPriority(stack.peek())) {
                    output += stack.pop().concat(" ");
                }
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop().concat(" ");
        }

        return output.split(WHITESPACE_PATTERN);
    }

    public static int calculateResult(final String input) {
        String[] postfix = convert(input);
        Stack<Integer> stack = new Stack<>();
        for (String str : postfix) {
            if (isNumber(str)) {
                stack.push(Integer.parseInt(str));
            } else if (OPERATORS.contains(str)) {
                int firstOperand = stack.pop();
                int secondOperand = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(secondOperand + firstOperand);
                        break;
                    case "-":
                        stack.push(secondOperand - firstOperand);
                        break;
                    case "*":
                        stack.push(secondOperand * firstOperand);
                        break;
                    case "/":
                        stack.push(secondOperand / firstOperand);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
