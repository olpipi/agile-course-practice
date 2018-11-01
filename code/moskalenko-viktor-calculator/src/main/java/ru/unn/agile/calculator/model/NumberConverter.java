package ru.unn.agile.calculator.model;

import java.lang.Integer;
import java.util.*;

public final class NumberConverter {

    private static final String UNKNOWN_NUMBER_LENGTH = "Unknown number length";
    private static final String UNKNOWN_NUMBER_SYSTEM = "Unknown number system";
    private static final Map<Character, Integer> LETTER_TO_SYSTEM;
    static {
        Map<Character, Integer> map = new TreeMap<>();
        map.put('b', 2);
        map.put('o', 8);
        map.put('x', 16);
        LETTER_TO_SYSTEM = Collections.unmodifiableMap(map);
    }

    public static int parse(final String number)
    {
        if (number.length() < 2) {
            throw new IllegalArgumentException(UNKNOWN_NUMBER_LENGTH);
        }
        char letter_system = number.charAt(0);
        if (!LETTER_TO_SYSTEM.containsKey(letter_system)) {
            throw new IllegalArgumentException(UNKNOWN_NUMBER_SYSTEM);
        }
        return Integer.parseInt(number.substring(1), LETTER_TO_SYSTEM.get(letter_system));
    }

    public static Integer tryParse(final String number) {
        try {
            return parse(number);
        }
        catch(Exception ex) {
            return null;
        }
    }

    public static String convert(int number, NumberSystem system) {
        boolean is_negative = number < 0;
        number = Math.abs(number);
        String result;

        switch (system) {
            case BINARY:
                result = "b" + Integer.toBinaryString(number);
                break;
            case OCTAL:
                result = "o" + Integer.toOctalString(number);
                break;
            case HEXADECIMAL:
                result = "x" + Integer.toHexString(number);
                break;
            default:
                throw new IllegalArgumentException(UNKNOWN_NUMBER_SYSTEM);
        }

        if (is_negative) {
            result = result.substring(0, 1) + "-" + result.substring(1);
        }
        return result;
    }

    private NumberConverter() {
        // no instance for class
    }
}
