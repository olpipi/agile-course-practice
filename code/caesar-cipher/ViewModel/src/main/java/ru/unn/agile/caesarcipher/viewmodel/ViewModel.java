package ru.unn.agile.caesarcipher.viewmodel;

import ru.unn.agile.caesarcipher.model.CaesarCipher;

public class ViewModel {
    private String inputTextBoxValue;
    private String offsetTextBoxValue;
    private String outputTextBoxValue;
    private String status;
    private String caesarCipher = "";

    private boolean codeButtonEnabled = false;

    public ViewModel() {
        inputTextBoxValue = "";
        offsetTextBoxValue = "";
        outputTextBoxValue = "";
        status = "";
    }

    public String getOutputTextBoxValue() {
        return outputTextBoxValue;
    }

    public void setInputTextBoxValue(final String value) {
        inputTextBoxValue = value;
    }

    public void setOffsetTextBoxValue(final String value) {
        offsetTextBoxValue = value;
    }

    public String getStatus() {
        return status;
    }

    public boolean isCodeButtonEnabled() {
        return codeButtonEnabled;
    }

    public void setTextBoxs(final String inputValue, final String offsetValue) {
        if ("".equals(offsetValue)) {
            codeButtonEnabled = false;
            status = "Input offset value";
            return;
        }
        if (!offsetValue.matches("\\d+")) {
            codeButtonEnabled = false;
            status = "Input correct value";
            return;
        }

        this.inputTextBoxValue = inputValue;
        this.offsetTextBoxValue = offsetValue;
        codeButtonEnabled = true;
        status = "Correct";
    }

    public void codeCaesar() {
        caesarCipher = CaesarCipher.encode(inputTextBoxValue, Integer.parseInt(offsetTextBoxValue));
    }

    public String getCaesarCipher() {
        return caesarCipher;
    }
}
