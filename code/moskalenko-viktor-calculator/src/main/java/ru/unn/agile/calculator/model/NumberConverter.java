package ru.unn.agile.calculator.model;

import java.lang.Integer;

public final class NumberConverter {
    public static int parse(final String number)
    {
        if (number.toLowerCase().startsWith("0b")) {
            return Integer.parseInt(number.substring(2), 2);
        } else {
            return Integer.decode(number);
        }
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
        switch (system) {
            case BINARY: return "0b" + Integer.toBinaryString(number);
            case OCTAL: return "0" + Integer.toOctalString(number);
            case HEXADECIMAL: return "0x" + Integer.toHexString(number);
        }
        throw new IllegalArgumentException("Unknown number system");
    }

    private NumberConverter() {
        // no instance for class
    }
}
