package ru.unn.agile.currencyconverter.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.currencyconverter.model.CurrencyConverter;

public class ViewModel {
    private StringProperty addSrcCodeStr = new SimpleStringProperty();
    private StringProperty addTgtCodeStr = new SimpleStringProperty();
    private StringProperty addRateStr = new SimpleStringProperty();

    private StringProperty convSrcCodeStr = new SimpleStringProperty();
    private StringProperty convTgtCodeStr = new SimpleStringProperty();
    private StringProperty convAmountStr = new SimpleStringProperty();

    private StringProperty currPairsSrt = new SimpleStringProperty();
    private StringProperty resultSrt = new SimpleStringProperty();

    public StringProperty getAddSrcCodeStr() {
        return addSrcCodeStr;
    }

    public StringProperty getAddTgtCodeStr() {
        return addTgtCodeStr;
    }

    public StringProperty getAddRateStr() {
        return addRateStr;
    }

    public StringProperty getConvSrcCodeStr() {
        return convSrcCodeStr;
    }

    public StringProperty getConvTgtCodeStr() {
        return convTgtCodeStr;
    }

    public StringProperty getConvAmountStr() {
        return convAmountStr;
    }

    public StringProperty getCurrPairsSrt() {
        return currPairsSrt;
    }

    public StringProperty getResultSrt() {
        return resultSrt;
    }

    public ViewModel() {
        initDefaultFields();
    }

    private void initDefaultFields() {
        addSrcCodeStr.set("");
        addTgtCodeStr.set("");
        addRateStr.set("");
        convSrcCodeStr.set("");
        convTgtCodeStr.set("");
        convAmountStr.set("");
        currPairsSrt.set("");
        resultSrt.set("");
    }
}
