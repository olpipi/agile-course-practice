package ru.unn.agile.InfixToPostfixNotationConverter.Model;

import java.util.*;

public final class InfixToPostfixNotationConverter {

    private static final String OPERATORS = "+-*/^";
    private static final String NUMBER_PATTERN = "[\\d]+";
    private static final String INVALID_INPUT_PATTERN = "\\d?\\W*";
    private static final String EMPTY_STRING_PATTERN = "^\\s*$";

    private InfixToPostfixNotationConverter() {
        /*empty*/
    }

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

    private static boolean invalidInput(final String str) {
        return str.matches(INVALID_INPUT_PATTERN) || str.matches(EMPTY_STRING_PATTERN);
    }

    public static String convert(final String input) throws RuntimeException {
        if (invalidInput(input)) {
            throw new RuntimeException("Wrong input!");
        }

        input.replaceAll("\\s+", "");

        String output = "";

        Stack<String> stack = new Stack<>();

        for (String str : input.split("")) {
            if ("(".equals(str)) {
                stack.push(str);
            } else if (isNumber(str)) {
                output += str;
            } else if (")".equals(str)) {
                while (!stack.peek().equals("(")) {
                    output += stack.pop();
                }
                stack.pop();
            } else if (OPERATORS.contains(str)) {
                while (!stack.isEmpty() && getPriority(str) <= getPriority(stack.peek())) {
                    output += stack.pop();
                }
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }

    public static int calculateResult(final String input) {
        String postfix = convert(input);
        Stack<Integer> stack = new Stack<>();
        for (String str : postfix.split("")) {
            if (isNumber(str)) {
                stack.push(Integer.parseInt(str));
            } else if (OPERATORS.contains(str)) {
                int num1 = 0;
                int num2 = 0;
                switch (str) {
                    case "+":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        stack.push(num2 / num1);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
