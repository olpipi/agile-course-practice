package ru.unn.agile.stringcalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringCalculator {
    private static final String DELIMITER_PATTERN = "(?s)^([^0-9])\\n.*";
    private static final String DEFAULT_DELIMITER = ",";
    private static final String NEW_LINE_DELIMITER = "\n";

    private StringCalculator() {

    }

    public static int add(final String numbers) {
        int numbersSum = 0;
        String delimiter = DEFAULT_DELIMITER;
        String modifiedNumbers = numbers;
        if (isNonDefaultDelimiter(modifiedNumbers)) {
            delimiter = getDelimiter(modifiedNumbers);
            modifiedNumbers = removeDelimiterFromString(modifiedNumbers, delimiter);
        }
        modifiedNumbers = replaceDelimiter(modifiedNumbers, NEW_LINE_DELIMITER);
        modifiedNumbers = replaceDelimiter(modifiedNumbers, delimiter);
        List<String> singleNumbers = getNumbersArrayFromString(modifiedNumbers);
        for (String number : singleNumbers) {
            numbersSum += Integer.parseInt(number);
        }
        return numbersSum;
    }

    private static List<String> getNumbersArrayFromString(final String numbersString) {
        List<String> numbersList = new ArrayList<>();
        if (!numbersString.isEmpty()) {
            if (numbersString.contains(DEFAULT_DELIMITER)) {
                numbersList = Arrays.asList(numbersString.split(DEFAULT_DELIMITER));
            } else {
                numbersList.add(numbersString);
            }
        }
        return numbersList;
    }

    private static boolean isNonDefaultDelimiter(final String s) {
        return s.matches(DELIMITER_PATTERN);
    }

    private static String getDelimiter(final String s) {
        Pattern compiledDelimiterPattern = Pattern.compile(DELIMITER_PATTERN);
        Matcher patternMatch = compiledDelimiterPattern.matcher(s);
        patternMatch.find();
        return patternMatch.group(1);
    }

    private static String removeDelimiterFromString(final String s, final String delimiter) {
        String tmpString;
        tmpString = s.replace(delimiter + NEW_LINE_DELIMITER, "");
        return tmpString;
    }

    private static String replaceDelimiter(final String s, final String delimiter) {
        return s.replace(delimiter, DEFAULT_DELIMITER);
    }
}
