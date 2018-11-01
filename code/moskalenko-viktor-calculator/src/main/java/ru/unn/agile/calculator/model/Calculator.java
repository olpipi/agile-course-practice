package ru.unn.agile.calculator.model;

public final class Calculator {

    private static final String INVALID_ARGUMENTS = "Invalid arguments";

    public static String add(String n1, String n2, NumberSystem outputFormat) {
        Integer value1 = NumberConverter.tryParse(n1);
        Integer value2 = NumberConverter.tryParse(n2);
        if ((value1 == null) || (value2 == null)) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        }
        int result = value1 + value2;
        return NumberConverter.convert(result, outputFormat);
    }

    public static String multiply(String n1, String n2, NumberSystem outputFormat) {
        Integer value1 = NumberConverter.tryParse(n1);
        Integer value2 = NumberConverter.tryParse(n2);
        if ((value1 == null) || (value2 == null)) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        }
        int result = value1 * value2;
        return NumberConverter.convert(result, outputFormat);
    }

    public static String unaryMinus(String number, NumberSystem outputFormat) {
        Integer value = NumberConverter.tryParse(number);
        if (value == null) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        }
        int result = -value;
        return NumberConverter.convert(result, outputFormat);
    }

    private Calculator() {
        // no instance for class
    }
}
