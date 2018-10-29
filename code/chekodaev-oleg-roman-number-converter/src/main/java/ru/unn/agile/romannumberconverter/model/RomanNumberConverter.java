package ru.unn.agile.romannumberconverter.model;

import java.util.Map;
import java.util.TreeMap;

public final class RomanNumberConverter {
    private RomanNumberConverter() {
        throw new UnsupportedOperationException();
    }

    public static final String OUT_OF_RANGE_ARABIC_VALUE = "Arabic_Out_Of_Range";
    public static final int INCORRECT_ROMAN_VALUE = -1;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;

    // Workaround to travis 'MagicNumber"
    private static final int I = 1;
    private static final int IV = 4;
    private static final int V = 5;
    private static final int IX = 9;
    private static final int X = 10;
    private static final int XL = 40;
    private static final int L = 50;
    private static final int XC = 90;
    private static final int C = 100;
    private static final int CD = 400;
    private static final int D = 500;
    private static final int CM = 900;
    private static final int M = 1000;

    private static final Map<Integer, String> BASE_NUMBER_MAP = new TreeMap<Integer, String>();
    static {
        BASE_NUMBER_MAP.put(I, "I");
        BASE_NUMBER_MAP.put(IV, "IV");
        BASE_NUMBER_MAP.put(V, "V");
        BASE_NUMBER_MAP.put(IX, "IX");
        BASE_NUMBER_MAP.put(X, "X");
        BASE_NUMBER_MAP.put(XL, "XL");
        BASE_NUMBER_MAP.put(L, "L");
        BASE_NUMBER_MAP.put(XC, "XC");
        BASE_NUMBER_MAP.put(C, "C");
        BASE_NUMBER_MAP.put(CD, "CD");
        BASE_NUMBER_MAP.put(D, "D");
        BASE_NUMBER_MAP.put(CM, "CM");
        BASE_NUMBER_MAP.put(M, "M");
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

    private static int getBaseNumberMapKey(final String value) {
        int res = 0;
        for (Map.Entry e : BASE_NUMBER_MAP.entrySet()) {
            if (((String) e.getValue()).equals(value)) {
                res = ((int) e.getKey());
            }
        }

        return res;
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
            int step = 1;

            // Check if one symbol in a row equals to value from baseNumbersMap.
            String str = String.valueOf(inputValue[i]);
            res = getBaseNumberMapKey(str);

            // Then check maybe two symbols in a row equals to value from baseNumbersMap.
            // This needs to define numbers like IX.
            if (i + 1 < inputValueLength) {
                str += String.valueOf(inputValue[i + 1]);
                int key = getBaseNumberMapKey(str);
                if (key != 0) {
                    res = key;
                    step = 2;
                }
            }

            if (res == 0) {
                return INCORRECT_ROMAN_VALUE;
            }
            arabicNumber += res;
            i += step;
        }

        // Easiest way to drop values which got from incorrect inputs like IXI, XIIIX, ...
        if (!romanNumber.equals(doConvertToRoman(arabicNumber))) {
            return INCORRECT_ROMAN_VALUE;
        }

        return arabicNumber;
    }
}
