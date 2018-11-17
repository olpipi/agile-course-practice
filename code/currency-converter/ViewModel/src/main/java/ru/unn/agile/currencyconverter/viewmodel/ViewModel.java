package ru.unn.agile.currencyconverter.viewmodel;

import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.currencyconverter.model.CurrencyConverter;
import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

public class ViewModel {
    private StringProperty addSrcCodeProp = new SimpleStringProperty();
    private StringProperty addTgtCodeProp = new SimpleStringProperty();
    private StringProperty addRateStrProp = new SimpleStringProperty();

    private StringProperty convSrcCodeProp = new SimpleStringProperty();
    private StringProperty convTgtCodeProp = new SimpleStringProperty();
    private StringProperty convAmountProp = new SimpleStringProperty();

    private StringProperty currPairsProp = new SimpleStringProperty();
    private StringProperty resultProp = new SimpleStringProperty();

    private CurrencyConverter currencyConverter = new CurrencyConverter();

    public StringProperty getAddSrcCodeProp() {
        return addSrcCodeProp;
    }

    public StringProperty getAddTgtCodeProp() {
        return addTgtCodeProp;
    }

    public StringProperty getAddRateStrProp() {
        return addRateStrProp;
    }

    public StringProperty getConvSrcCodeProp() {
        return convSrcCodeProp;
    }

    public StringProperty getConvTgtCodeProp() {
        return convTgtCodeProp;
    }

    public StringProperty getConvAmountProp() {
        return convAmountProp;
    }

    public String getCurrPairsStr() {
        return currPairsProp.get();
    }

    public String getResultStr() {
        return resultProp.get();
    }

    public ViewModel() {
        initDefaultFields();
    }

    private void initDefaultFields() {
        addSrcCodeProp.set("");
        addTgtCodeProp.set("");
        addRateStrProp.set("");
        convSrcCodeProp.set("");
        convTgtCodeProp.set("");
        convAmountProp.set("");
        currPairsProp.set("");
        resultProp.set("");
    }

    public void addCurrencyPair() {
        try {
            currencyConverter.addCurrencyPair(
                    addSrcCodeProp.get(),
                    addTgtCodeProp.get(),
                    Double.parseDouble(addRateStrProp.get())
            );
        } catch (NumberFormatException exc) {
            resultProp.set("Не удалось распознать число: \"" + addRateStrProp.get() + "\"");
            return;
        } catch (CurrencyConverterException exc) {
            resultProp.set("Ошибка: " + exc.getMessage());
            return;
        }

        Map<String, Double> currencyPairs = currencyConverter.getCurrencyPairs();
        for (String pair : currencyPairs.keySet()) {
            currPairsProp.set(currPairsProp.get() + pair + "\n");
        }

        resultProp.set("");
    }

    public void convertCurrency() {
        Double amount, res;

        try {
            amount = Double.parseDouble(convAmountProp.get());
        }
        catch (NumberFormatException exc) {
            resultProp.set("Не удалось распознать число: \"" + convAmountProp.get() + "\"");
            return;
        }

        try {
            res = currencyConverter.convert(
                    convSrcCodeProp.get(),
                    convTgtCodeProp.get(),
                    amount
            );
        }
        catch (CurrencyConverterException exc) {
            resultProp.set("Ошибка: " + exc.getMessage());
            return;
        }

        resultProp.set(String.format("%s %s = %s %s",
                amount,
                convSrcCodeProp.get(),
                res,
                convTgtCodeProp.get()));
    }
}
