package ru.unn.agile.calculator.model;

import com.sun.istack.internal.NotNull;

public final class Calculator {

    private static final String INVALID_ARGUMENTS_MESSAGE = "Invalid arguments";

    public static String add(String n1, String n2, NumberSystem outputFormat) {
        Integer value1 = NumberConverter.tryParse(n1);
        Integer value2 = NumberConverter.tryParse(n2);
        if ((value1 == null) || (value2 == null)) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS_MESSAGE);
        }
        int result = value1 + value2;
        return NumberConverter.convert(result, outputFormat);
    }
}
