package ru.unn.agile.romannumberconverter.model;

import java.util.Map;
import java.util.TreeMap;

public final class RomanNumberConverter {
    public static final String OUT_OF_RANGE_ARABIC_VALUE = "Arabic_Out_Of_Range";

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;

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

    private static String doConvertToRoman(final int arabicNumber) {
        String romanNumber = "";
        int nearestKey = ((TreeMap<Integer, String>) BASE_NUMBER_MAP).floorKey(arabicNumber);
        if (nearestKey == arabicNumber) {
            romanNumber = BASE_NUMBER_MAP.get(arabicNumber);
        } else {
            romanNumber = BASE_NUMBER_MAP.get(nearestKey)
                    + doConvertToRoman(arabicNumber - nearestKey);
        }

        return romanNumber;
    }

    public static String convertToRoman(final int arabicNumber) {
        if (arabicNumber < MIN_VALUE || arabicNumber > MAX_VALUE) {
            return OUT_OF_RANGE_ARABIC_VALUE;
        }

        return doConvertToRoman(arabicNumber);
    }

    public static int convertToArabic(final String romanNumber) {
        int arabicNumber = 0;
        char[] inputValue = romanNumber.toCharArray();
        int inputValueLength = inputValue.length;
        int i = 0;
        while (i < inputValueLength) {
            int res = 0;
            int step = 0;

            String str = String.valueOf(inputValue[i]);
            for (Map.Entry e : BASE_NUMBER_MAP.entrySet()) {
                if (((String) e.getValue()).equals(str)) {
                    res = ((int) e.getKey());
                    step = 1;
                }
            }

            if (i + 1 < inputValueLength) {
                str += String.valueOf(inputValue[i + 1]);
                for (Map.Entry e : BASE_NUMBER_MAP.entrySet()) {
                    if (((String) e.getValue()).equals(str)) {
                        res = ((int) e.getKey());
                        step = 2;
                    }
                }
            }

            arabicNumber += res;
            i += step;
        }

        return arabicNumber;
    }
}
