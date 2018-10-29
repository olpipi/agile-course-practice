package ru.unn.agile.romannumberconverter.model;

import java.util.Map;
import java.util.TreeMap;

public final class RomanNumberConverter {
    private static final Map<Integer, String> BASE_NUMBER_MAP = new TreeMap<Integer, String>();
    static {
        BASE_NUMBER_MAP.put(1, "I");
        BASE_NUMBER_MAP.put(4, "IV");
        BASE_NUMBER_MAP.put(5, "V");
        BASE_NUMBER_MAP.put(9, "IX");
        BASE_NUMBER_MAP.put(10, "X");
        BASE_NUMBER_MAP.put(40, "XL");
        BASE_NUMBER_MAP.put(50, "L");
        BASE_NUMBER_MAP.put(90, "XC");
        BASE_NUMBER_MAP.put(100, "C");
        BASE_NUMBER_MAP.put(400, "CD");
        BASE_NUMBER_MAP.put(500, "D");
        BASE_NUMBER_MAP.put(900, "CM");
        BASE_NUMBER_MAP.put(1000, "M");
    }

    public static String convertToRoman(final int arabicNumber) {
        String romanNumber = "";
        int nearestKey = ((TreeMap<Integer, String>) BASE_NUMBER_MAP).floorKey(arabicNumber);
        if (nearestKey == arabicNumber) {
            romanNumber = BASE_NUMBER_MAP.get(arabicNumber);
        } else {
            romanNumber = BASE_NUMBER_MAP.get(nearestKey)
                    + convertToRoman(arabicNumber - nearestKey);
        }

        return romanNumber;
    }
}
