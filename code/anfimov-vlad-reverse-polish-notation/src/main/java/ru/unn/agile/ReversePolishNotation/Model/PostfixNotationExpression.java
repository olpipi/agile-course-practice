package ru.unn.agile.ReversePolishNotation.Model;

import java.util.*;

public class PostfixNotationExpression {

    private String operators = "+-*/^";

    public PostfixNotationExpression() {
        /*empty*/
    }

    private int getPriority(final String operator) {
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

    private boolean isNumber(final String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public String[] convertToPostfixNotation(final String input) throws RuntimeException {
        if (input.isEmpty() || input.split(" ").length == 0) {
            throw new RuntimeException("String can't be empty");
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
            } else if (operators.contains(str)) {
                while (!stack.isEmpty() && getPriority(str) <= getPriority(stack.peek())) {
                    output += stack.pop();
                }
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output.split("");
    }

    public int calculateResult(final String input) {
        String[] postfix = convertToPostfixNotation(input);
        Stack<Integer> stack = new Stack<>();
        for (String str : postfix) {
            if (isNumber(str)) {
                stack.push(Integer.parseInt(str));
            } else if (operators.contains(str)) {
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
