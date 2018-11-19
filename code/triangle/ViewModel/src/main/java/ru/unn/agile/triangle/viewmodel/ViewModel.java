package ru.unn.agile.triangle.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private StringProperty aStr = new SimpleStringProperty();
    private StringProperty bStr = new SimpleStringProperty();
    private StringProperty cStr = new SimpleStringProperty();
    private StringProperty resultSrt = new SimpleStringProperty();

    public StringProperty getAStr() {
        return aStr;
    }

    public StringProperty getBStr() {
        return bStr;
    }

    public StringProperty getCStr() {
        return cStr;
    }

    public StringProperty getResultSrt() {
        return resultSrt;
    }

    public ViewModel() {
        initDefaultFields();
    }

    private void initDefaultFields() {
        aStr.set("");
        bStr.set("");
        cStr.set("");
        resultSrt.set("");
    }
}
