package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ViewModel {
    private final StringProperty inputData = new SimpleStringProperty();

    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));

    public ViewModel() {
        inputData.set("");
        operation.set(Operation.ADD);
    }

    public StringProperty inputDataProperty() {
        return inputData;
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public void calculate() {

    }


}