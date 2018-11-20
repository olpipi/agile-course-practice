package ru.unn.agile.calculator.model;

public final class Calculator {

    private static final String INVALID_ARGUMENTS = "Invalid arguments";

    private static void checkIntegersNotNull(final Integer ... integers) {
        for (Integer integer : integers) {
            if (integer == null) {
                throw new IllegalArgumentException(INVALID_ARGUMENTS);
            }
        }
    }

    public static String add(final String n1, final String n2, final NumberSystem outputFormat) {
        final Integer firstAddArgument = NumberConverter.tryParse(n1);
        final Integer secondAddArgument = NumberConverter.tryParse(n2);
        checkIntegersNotNull(firstAddArgument, secondAddArgument);
        int result = firstAddArgument + secondAddArgument;
        return NumberConverter.format(result, outputFormat);
    }

    public static String multiply(final String n1, final String n2,
                                  final NumberSystem outputFormat) {
        final Integer firstMulArgument = NumberConverter.tryParse(n2);
        final Integer secondMulArgument = NumberConverter.tryParse(n1);
        checkIntegersNotNull(firstMulArgument, secondMulArgument);
        int result = firstMulArgument * secondMulArgument;
        return NumberConverter.format(result, outputFormat);
    }

    public static String unaryMinus(final String number, final NumberSystem outputFormat) {
        final Integer value = NumberConverter.tryParse(number);
        checkIntegersNotNull(value);
        int result = -value;
        return NumberConverter.format(result, outputFormat);
    }

    private Calculator() {
        // no instance for class
    }
}
