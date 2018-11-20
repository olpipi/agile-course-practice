package ru.unn.agile.calculator.viewmodel;

import javafx.beans.property.*;
import ru.unn.agile.calculator.model.NumberSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maria Pronina.
 */
public class ViewModel {

    private final ObjectProperty<NumberSystem> numberSystem = new SimpleObjectProperty<>();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty userMessage = new SimpleStringProperty();
    private final StringProperty number1 = new SimpleStringProperty();
    private final StringProperty number2 = new SimpleStringProperty();
    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    public NumberSystem getNumberSystem() {
        return numberSystem.get();
    }

    public ViewModel() {
        numberSystem.setValue(NumberSystem.BINARY);
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
}
