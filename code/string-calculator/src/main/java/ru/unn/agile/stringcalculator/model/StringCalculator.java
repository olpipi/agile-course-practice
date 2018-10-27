package ru.unn.agile.stringcalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITER_PATTERN = "^([^0-9])\\n.*";
    private static final String DEFAULT_DELIMITER = ",";
    private static final String NEW_LINE_DELIMITER = "\n";
    private String delimiter = DEFAULT_DELIMITER;

    public static int Add(String numbers) {
        int numbersSum = 0;
        String delimiter = DEFAULT_DELIMITER;
        if (isNonDefaultDelimiter(numbers))
        {
            delimiter = getDelimiter(numbers);
            numbers = removeDelimiterFromString(numbers, delimiter);
        }
        numbers = replaceDelimiter(numbers, NEW_LINE_DELIMITER);
        numbers = replaceDelimiter(numbers, delimiter);
        List<String> singleNumbers = getNumbersArrayFromString(numbers);
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

    private static boolean isNonDefaultDelimiter(String s) {
        return s.matches(DELIMITER_PATTERN);
    }

    private static String getDelimiter(String s) {
        Pattern compiled_delimiter_pattern = Pattern.compile(DELIMITER_PATTERN);
        Matcher pattern_match = compiled_delimiter_pattern.matcher(s);
        pattern_match.find();
        return pattern_match.group(1);
    }

    private static String removeDelimiterFromString(String s, String delimiter) {
        String tmpString;
        tmpString = s.replace(delimiter + NEW_LINE_DELIMITER, "");
        return tmpString;
    }

    private static String replaceDelimiter(String s, String delimiter) {
        return s.replace(delimiter, DEFAULT_DELIMITER);
    }
}
