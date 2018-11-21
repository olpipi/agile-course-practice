package ru.unn.agile.calculator.viewmodel;

import javafx.beans.property.*;
import ru.unn.agile.calculator.model.Calculator;
import ru.unn.agile.calculator.model.NumberSystem;

/**
 * Created by Maria Pronina.
 */
public class ViewModel {

    private final ObjectProperty<NumberSystem> inputNumberSystem = new SimpleObjectProperty<>();
    private final ObjectProperty<NumberSystem> outputNumberSystem = new SimpleObjectProperty<>();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty userMessage = new SimpleStringProperty();
    private final StringProperty number1 = new SimpleStringProperty();
    private final StringProperty number2 = new SimpleStringProperty();
    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    public NumberSystem getInputNumberSystem() {
        return inputNumberSystem.get();
    }

    public ViewModel() {
        inputNumberSystem.setValue(NumberSystem.BINARY);
        outputNumberSystem.setValue(NumberSystem.BINARY);
        result.setValue("");
        userMessage.setValue("");
        calculationDisabled.setValue(true);
        number1.setValue("");
        number2.setValue("");
    }

    public String getResult() {
        return result.get();
    }

    public String getUserMessage() {
        return userMessage.get();
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }
    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    public StringProperty number1Property() {
        return number1;
    }

    public StringProperty number2Property() {
        return number2;
    }

    public void calculate() {
        NumberSystem currentSystem = getOutputNumberSystem();
        String a = number1.get();
        String b = number2.get();

        String composedResult = buildSumResult(currentSystem, a, b)
                + buildMultResult(currentSystem, a, b)
                + buildUnaryMinusResult(currentSystem, a, b);
        result.setValue(composedResult);
    }

    private String buildUnaryMinusResult(NumberSystem currentSystem, String a, String b) {
        return "Minus: -a = " + Calculator.unaryMinus(a, currentSystem) + ", -b = " + Calculator.unaryMinus(b, currentSystem) + "\n";
    }

    private String buildMultResult(NumberSystem currentSystem, String a, String b) {
        return "Mult: a*b = " + Calculator.multiply(a, b, currentSystem) + "\n";
    }

    private String buildSumResult(NumberSystem currentSystem, String a, String b) {
        return "Sum: a+b = " + Calculator.add(a, b, currentSystem) + "\n";
    }

    public NumberSystem getOutputNumberSystem() {
        return outputNumberSystem.get();
    }
}
