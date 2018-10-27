package ru.unn.agile.stringcalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final String DELIMITER = ",";

    public static int Add(String numbers) {
        int numbersSum = 0;
        List<String> singleNumbers = getNumbersArrayFromString(numbers);
        for (String number : singleNumbers) {
            numbersSum += Integer.parseInt(number);
        }
        return numbersSum;
    }

    public static List<String> getNumbersArrayFromString(String numbersString) {
        List<String> numbersList = new ArrayList<>();
        if (!numbersString.isEmpty()) {
            if (numbersString.contains(DELIMITER)) {
                numbersList = Arrays.asList(numbersString.split(DELIMITER));
            }
            else {
                numbersList.add(numbersString);
            }
        }
        return numbersList;
    }

    public static String replaceNewLines(String s) {
        return "";
    }
}
