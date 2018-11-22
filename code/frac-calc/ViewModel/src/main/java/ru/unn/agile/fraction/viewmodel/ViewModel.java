package ru.unn.agile.fraction.viewmodel;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.fraction.model.Fraction;
import ru.unn.agile.fraction.model.Fraction.Operation;

public class ViewModel {
    private StringProperty firstNumerator = new SimpleStringProperty();
    private StringProperty firstDenominator = new SimpleStringProperty();
    private StringProperty secondNumerator = new SimpleStringProperty();
    private StringProperty secondDenominator = new SimpleStringProperty();

    private ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));
    private ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private StringProperty resultNumerator = new SimpleStringProperty();
    private StringProperty resultDenominator = new SimpleStringProperty();

    private final StringProperty status = new SimpleStringProperty();

    public ViewModel() {
        initDefaultFields();
    }

    private void initDefaultFields() {
        firstNumerator.set("");
        firstDenominator.set("");
        secondNumerator.set("");
        secondDenominator.set("");
        operation.set(Operation.ADD);
        resultNumerator.set("");
        resultDenominator.set("");
        status.set(Status.WAITING.toString());

    }

    public StringProperty firstNumeratorProperty() {
        return firstNumerator;
    }

    public StringProperty firstDenominatorProperty() {
        return firstDenominator;
    }

    public StringProperty secondNumeratorProperty() {
        return secondNumerator;
    }

    public StringProperty secondDenominatorProperty() {
        return secondDenominator;
    }

    public StringProperty resultNumeratorProperty() {
        return resultNumerator;
    }

    public StringProperty resultDenominatorProperty() {
        return resultDenominator;
    }

    public final ObservableList<Operation> getOperations() {
        return operations.get();
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

}

enum Status {
    WAITING("Please provide input data"),
    READY("Press '=' button"),
    BAD_FORMAT("Bad input data format"),
    SUCCESS("Success");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
