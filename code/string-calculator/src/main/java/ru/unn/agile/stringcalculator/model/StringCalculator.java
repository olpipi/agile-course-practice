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
        String numbersListWithDefaultDelimeter = replaceNewLines(numbersString);
        if (!numbersListWithDefaultDelimeter.isEmpty()) {
            if (numbersListWithDefaultDelimeter.contains(DELIMITER)) {
                numbersList = Arrays.asList(numbersListWithDefaultDelimeter.split(DELIMITER));
            }
            else {
                numbersList.add(numbersListWithDefaultDelimeter);
            }
        }
        return numbersList;
    }

    public static String replaceNewLines(String s) {
        String replacedString = s.replace("\n", DELIMITER);
        return replacedString;
    }
}
