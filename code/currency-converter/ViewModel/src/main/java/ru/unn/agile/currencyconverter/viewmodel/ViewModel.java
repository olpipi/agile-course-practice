package ru.unn.agile.currencyconverter.viewmodel;

import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.currencyconverter.model.CurrencyConverter;
import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

public class ViewModel {
    private StringProperty addSrcCodeStr = new SimpleStringProperty();
    private StringProperty addTgtCodeStr = new SimpleStringProperty();
    private StringProperty addRateStr = new SimpleStringProperty();

    private StringProperty convSrcCodeStr = new SimpleStringProperty();
    private StringProperty convTgtCodeStr = new SimpleStringProperty();
    private StringProperty convAmountStr = new SimpleStringProperty();

    private StringProperty currPairsStr = new SimpleStringProperty();
    private StringProperty resultSrt = new SimpleStringProperty();

    private CurrencyConverter currencyConverter = new CurrencyConverter();

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

    public StringProperty getCurrPairsStr() {
        return currPairsStr;
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
        currPairsStr.set("");
        resultSrt.set("");
    }

    public void addCurrencyPair() {
        try {
            currencyConverter.addCurrencyPair(
                    addSrcCodeStr.get(),
                    addTgtCodeStr.get(),
                    Double.parseDouble(addRateStr.get())
            );
        }
        catch (NumberFormatException exc) {
            resultSrt.set("Не удалось распознать число: \"" + addRateStr.get() + "\"");
            return;
        }
        catch (CurrencyConverterException exc) {
            resultSrt.set("Ошибка: " + exc.getMessage());
            return;
        }

        Map<String, Double> currencyPairs = currencyConverter.getCurrencyPairs();
        for (String pair : currencyPairs.keySet()) {
            currPairsStr.set(currPairsStr.get() + pair + "\n");
        }

        resultSrt.set("");
    }
}
