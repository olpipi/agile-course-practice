package ru.unn.agile.stringcalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final String DELIMITER = ",";

    public static int Add(String numbers) {
        if (numbers.length() > 0) {
            if (numbers.contains(",")) {
                List<String> singleNumbers = Arrays.asList(numbers.split(","));
                return Integer.parseInt(singleNumbers.get(0)) + Integer.parseInt(singleNumbers.get(1));
            }

            return Integer.parseInt(numbers);
        }
        return 0;
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
}
