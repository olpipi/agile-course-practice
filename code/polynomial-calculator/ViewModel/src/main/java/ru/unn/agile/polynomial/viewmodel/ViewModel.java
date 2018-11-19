package ru.unn.agile.polynomial.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.polynomial.model.Polynomial;

public class ViewModel {
    private StringProperty firstPolynomialStr = new SimpleStringProperty();
    private StringProperty secondPolynomialStr = new SimpleStringProperty();
    private StringProperty resultSrt = new SimpleStringProperty();

    public StringProperty getFirstPolynomialStr() {
        return firstPolynomialStr;
    }

    public StringProperty getSecondPolynomialStr() {
        return secondPolynomialStr;
    }

    public StringProperty getResultSrt() {
        return resultSrt;
    }

    public ViewModel() {
        initDefaultFields();
    }

    private void initDefaultFields() {
        firstPolynomialStr.set("");
        secondPolynomialStr.set("");
        resultSrt.set("");
    }
}