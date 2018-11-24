package ru.unn.agile.numberinwords.viewmodel;

import ru.unn.agile.numberinwords.model.NumbersInWords;

public class NumbersInWordsViewModel {
    private String errorMessage = "";
    private String number = "";
    private String numberInWords = "";
    private boolean convertButtonEnabled = false;

    public boolean isConvertButtonEnabled() {
        return convertButtonEnabled;
    }

    public void setNumber(final String numbers) {
        if ("".equals(numbers)) {
            error("");
            return;
        }
        if (!numbers.matches("\\d+")) {
            error("Only digits, please");
            return;
        }
        this.number = numbers;
        errorMessage = "";
        convertButtonEnabled = true;
    }

    private void error(final String message) {
        errorMessage = message;
        convertButtonEnabled = false;
    }

    public String getNumberInWords() {
        return numberInWords;
    }

    public void convert() {
        numberInWords = NumbersInWords.convert(Integer.parseInt(number));
    }

    public String deleteNumberInWords() {
        numberInWords = "";
        return numberInWords;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
