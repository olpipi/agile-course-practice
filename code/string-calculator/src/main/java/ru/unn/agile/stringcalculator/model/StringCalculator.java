package ru.unn.agile.stringcalculator.model;

public class StringCalculator {

    public static int Add(String numbers) {
        if (numbers.length() > 0)
        {
            return Integer.parseInt(numbers);
        }
        return 0;
    }
}
