package ru.unn.agile.numbersIn-words.model;

import java.text.DecimalFormat;

public final class NumbersInWords {
    private static final String[] TENSNAMES = {
            "", " Ten", " Twenty", " Thirty", " Forty", " Fifty",
            " Sixty", " Seventy", " Eighty", " Ninety"
    };
    private static final String[] NUMNAMES = {
            "", " One", " Two", " Three", " Four", " Five", " Six",
            " Seven", " Eight", " Nine", " Ten",
            " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen",
            " Sixteen", " Seventeen", " Eighteen", " Nineteen"
    };

    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int SIX = 6;
    private static final int NINE = 9;
    private static final int TWELVE = 12;
    private static final int TWENTY = 20;

    private NumbersInWords() {
    }

    private static String convertLessThanOneThousand(final int number) {
        String PartNumber;
        int newNumber = number;
        if (number % HUNDRED < TWENTY) {
            PartNumber = NUMNAMES[number % HUNDRED];
            newNumber = number / HUNDRED;
        } else {
            PartNumber = NUMNAMES[number % TEN];
            newNumber = number / TEN;
            PartNumber = TENSNAMES[newNumber % TEN] + PartNumber;
            newNumber = newNumber / TEN;
        }
        if (number == 0) {
            return PartNumber;
        }
        return NUMNAMES[newNumber] + " hundred" + PartNumber;
    }

    public static String convert(final long number) {
        if (number == 0) {
            return "zero";
        }
        String snumber = Long.toString(number);
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(ZERO, THREE));
        int millions  = Integer.parseInt(snumber.substring(THREE, SIX));
        int hundredThousands = Integer.parseInt(snumber.substring(SIX, NINE));
        int thousands = Integer.parseInt(snumber.substring(NINE, TWELVE));

        String tradBillions;
        if (billions == 0) {
            tradBillions = "";
        } else {
            tradBillions = convertLessThanOneThousand(billions) + " billion ";
        }
        String result =  tradBillions;

        String tradMillions;
        if (millions == 0) {
            tradMillions = "";
        } else {
            tradMillions = convertLessThanOneThousand(millions) + " million ";
        }
        result =  result + tradMillions;

        String tradHundredThousands;
        if (hundredThousands == 0) {
            tradHundredThousands = "";
        } else {
            tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result =  result + tradThousand;
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}