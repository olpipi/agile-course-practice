package ru.unn.agile.calculator.model;

import java.util.*;

public final class NumberConverter {

    private static final String UNKNOWN_NUMBER_LENGTH = "Unknown number length";
    private static final String UNKNOWN_NUMBER_SYSTEM = "Unknown number system";
    private static final Map<Character, Integer> LETTER_TO_SYSTEM;
    private static final int BINARY_SYSTEM = 2;
    private static final int OCTAL_SYSTEM = 8;
    private static final int HEXADECIMAL_SYSTEM = 16;

    static {
        Map<Character, Integer> map = new TreeMap<>();
        map.put('b', BINARY_SYSTEM);
        map.put('o', OCTAL_SYSTEM);
        map.put('x', HEXADECIMAL_SYSTEM);
        LETTER_TO_SYSTEM = Collections.unmodifiableMap(map);
    }

    public static int parse(final String number) {
        if (number.length() < 2) {
            throw new IllegalArgumentException(UNKNOWN_NUMBER_LENGTH);
        }
        final char letterSystem = number.charAt(0);
        if (!LETTER_TO_SYSTEM.containsKey(letterSystem)) {
            throw new IllegalArgumentException(UNKNOWN_NUMBER_SYSTEM);
        }
        return Integer.parseInt(number.substring(1), LETTER_TO_SYSTEM.get(letterSystem));
    }

    public static Integer tryParse(final String number) {
        try {
            return parse(number);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String format(final int number, final NumberSystem system) {
        final boolean isNegative = number < 0;
        final int numberModule = Math.abs(number);
        String result;

        switch (system) {
            case BINARY:
                result = "b" + Integer.toBinaryString(numberModule);
                break;
            case OCTAL:
                result = "o" + Integer.toOctalString(numberModule);
                break;
            case HEXADECIMAL:
                result = "x" + Integer.toHexString(numberModule);
                break;
            default:
                throw new IllegalArgumentException(UNKNOWN_NUMBER_SYSTEM);
        }

        if (isNegative) {
            result = result.substring(0, 1) + "-" + result.substring(1);
        }
        return result;
    }

    private NumberConverter() {
        // no instance for class
    }
}
