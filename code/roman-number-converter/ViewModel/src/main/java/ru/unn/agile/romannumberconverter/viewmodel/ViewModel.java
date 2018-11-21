package ru.unn.agile.romannumberconverter.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private StringProperty arabicValueStr = new SimpleStringProperty();
    private StringProperty romanValueStr = new SimpleStringProperty();

    public String getArabicValueStr() {
        return arabicValueStr.get();
    }

    public String getRomanValueStr() {
        return romanValueStr.get();
    }

    public ViewModel() {
        initialize();
    }

    private void initialize() {
        arabicValueStr.set("");
        romanValueStr.set("");
    }
}
