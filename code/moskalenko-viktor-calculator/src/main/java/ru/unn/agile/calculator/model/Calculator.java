package ru.unn.agile.calculator.model;

public final class Calculator {

    private static final String INVALID_ARGUMENTS = "Invalid arguments";

    public static String add(final String n1, final String n2, final NumberSystem outputFormat) {
        final Integer firstAddArgument = NumberConverter.tryParse(n1);
        final Integer secondAddArgument = NumberConverter.tryParse(n2);
        if ((firstAddArgument == null) || (secondAddArgument == null)) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        }
        int result = firstAddArgument + secondAddArgument;
        return NumberConverter.format(result, outputFormat);
    }

    public static String multiply(final String n1, final String n2,
                                  final NumberSystem outputFormat) {
        final Integer firstMulArgument = NumberConverter.tryParse(n2);
        final Integer secondMulArgument = NumberConverter.tryParse(n1);
        if ((firstMulArgument == null) || (secondMulArgument == null)) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        }
        int result = firstMulArgument * secondMulArgument;
        return NumberConverter.format(result, outputFormat);
    }

    public static String unaryMinus(final String number, final NumberSystem outputFormat) {
        final Integer value = NumberConverter.tryParse(number);
        if (value == null) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        }
        int result = -value;
        return NumberConverter.format(result, outputFormat);
    }

    private Calculator() {
        // no instance for class
    }
}
