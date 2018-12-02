package ru.unn.agile.matrix.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ViewModel {
    private final StringProperty matrixA = new SimpleStringProperty();
    private final StringProperty matrixB = new SimpleStringProperty();
    public final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));
    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final BooleanProperty calculateButtonDisabled = new SimpleBooleanProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final ValueChangeListener valueChangeListener = new ValueChangeListener();

    public ViewModel() {
        operation.setValue(Operation.ADD);
    }

    public StringProperty matrixAProperty() {
        return matrixA;
    }

    public StringProperty matrixBProperty() {
        return matrixB;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public ObjectProperty<ObservableList<Operation>> operationsProperty() {
        return operations;
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public BooleanProperty calculateButtonDisabledProperty() {
        return calculateButtonDisabled;
    }

    public Status getInputStatus() {
        return Status.WAITING;
    }

    public void calculate() {
        //empty for now
    }

    private boolean canCalculate() {
        return true;
        // return getInputStatus() == Status.READY;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
            calculateButtonDisabled.set(!canCalculate());
        }
    }
}

enum Status {
    WAITING("Waiting for input"),
    READY("Press 'Calculate' button"),
    BAD_FORMAT("Bad format"),
    SUCCESS("Success");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

