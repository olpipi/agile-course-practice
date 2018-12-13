package ru.unn.agile.caesarcipher.viewmodel;

import ru.unn.agile.caesarcipher.model.CaesarCipher;

public class ViewModel {
    private String inputTextBoxValue;
    private String offsetTextBoxValue;
    private String status;
    private String caesarCipher = "";

    private static final String DIGIT = "\\d+";
    private static final String READY = "Correct";
    private static final String BADINPUT = "Input correct value";

    private boolean codeButtonEnabled = false;

    public ViewModel() {
        inputTextBoxValue = "";
        offsetTextBoxValue = "";
        status = "";
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
            status = BADINPUT;
            return;
        }
        if (!offsetValue.matches(DIGIT)) {
            codeButtonEnabled = false;
            status = BADINPUT;
            return;
        }

        this.inputTextBoxValue = inputValue;
        this.offsetTextBoxValue = offsetValue;
        codeButtonEnabled = true;
        status = READY;
    }

    public void codeCaesar() {
        caesarCipher = CaesarCipher.encode(inputTextBoxValue, Integer.parseInt(offsetTextBoxValue));
    }

    public String getCaesarCipher() {
        return caesarCipher;
    }
}
