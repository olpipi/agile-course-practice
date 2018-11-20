package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private final StringProperty inputData = new SimpleStringProperty();

    public ViewModel() {
        inputData.set("");
    }

    public StringProperty inputDataProperty() {
        return inputData;
    }
}
