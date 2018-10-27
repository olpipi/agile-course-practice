package ru.unn.agile.stringcalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",";
    private String delimiter = DEFAULT_DELIMITER;

    public static int Add(String numbers) {
        int numbersSum = 0;
        String numbersListWithDefaultDelimeter = replaceNewLines(numbers);
        List<String> singleNumbers = getNumbersArrayFromString(numbersListWithDefaultDelimeter);
        for (String number : singleNumbers) {
            numbersSum += Integer.parseInt(number);
        }
        return numbersSum;
    }

    private static List<String> getNumbersArrayFromString(String numbersString) {
        List<String> numbersList = new ArrayList<>();
        if (!numbersString.isEmpty()) {
            if (numbersString.contains(DEFAULT_DELIMITER)) {
                numbersList = Arrays.asList(numbersString.split(DEFAULT_DELIMITER));
            }
            else {
                numbersList.add(numbersString);
            }
        }
        return numbersList;
    }

    private static String replaceNewLines(String s) {
        String replacedString = s.replace("\n", DEFAULT_DELIMITER);
        return replacedString;
    }
}
