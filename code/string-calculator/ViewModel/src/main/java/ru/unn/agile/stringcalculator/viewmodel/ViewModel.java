package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.stringcalculator.model.StringCalculator;
import ru.unn.agile.stringcalculator.model.errorhandling.NegativeNumberException;
import ru.unn.agile.stringcalculator.model.errorhandling.NotANumberException;
import ru.unn.agile.stringcalculator.viewmodel.actions.ActionFactory;
import ru.unn.agile.stringcalculator.viewmodel.actions.abstraction.IAction;

public class ViewModel {
    private final StringProperty inputData = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));

    public ViewModel() {
        inputData.set("");
        operation.set(Operation.ADD);

        inputData.addListener(new ValueChangeListener());

        initCalculateButtonState();

        status.set(Status.WAITING.toString());
    }

    public StringProperty inputDataProperty() {
        return inputData;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }

    public Operation getOperation() {
        return operation.get();
    }

    public boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    private IAction createActionByOperation(Operation operation) {
        IAction action = ActionFactory.create(operation);;
        if (action == null) {
            throw new RuntimeException("Action is null");
        }
        return ActionFactory.create(operation);
    }

    public void calculate() {
        if (isCalculationDisabled()) {
            return;
        }

        Operation currentOperation = getOperation();

        int resultExpression = createActionByOperation(currentOperation).calculate(inputDataProperty().get());

        result.set(Integer.toString(resultExpression));
        status.set(Status.SUCCESS.toString());
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (inputData.get().equals("")) {
            inputStatus = Status.WAITING;
        }
        try {
            StringCalculator.validate(inputData.get());
        } catch (NotANumberException | NegativeNumberException e) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }

    private void initCalculateButtonState() {
        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(inputData);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
        }
    }

}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Calculate' or Enter"),
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
