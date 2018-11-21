package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.stringcalculator.viewmodel.actions.ActionFactory;
import ru.unn.agile.stringcalculator.viewmodel.actions.abstraction.IAction;

public class ViewModel {
    private final StringProperty inputData = new SimpleStringProperty();

    private final StringProperty result = new SimpleStringProperty();

    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));

    public ViewModel() {
        inputData.set("");
    }

    public StringProperty inputDataProperty() {
        return inputData;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public Operation getOperation() {
        return operation.get();
    }

    public final ObservableList<Operation> getOperations() {
        return operations.get();
    }

    private IAction createActionByOperation(Operation operation) {
        return ActionFactory.create(operation);
    }

    public void calculate() {
        Operation currentOperation = getOperation();

        int resultExpression = createActionByOperation(currentOperation).calculate(inputDataProperty().get());

        result.set(Integer.toString(resultExpression));
    }

}