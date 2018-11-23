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

import java.util.List;

public class ViewModel {
    private final StringProperty inputData = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final StringProperty logs = new SimpleStringProperty();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));

    private ILogger logger;

    public final void setLogger(final ILogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger parameter can't be null");
        }
        this.logger = logger;
    }

    public final List<String> getLog() {
        return logger.getLog();
    }

    public ViewModel() {
        init();
    }

    public ViewModel(final ILogger logger) {
        setLogger(logger);
        init();
    }

    private void init() {
        inputData.set("");
        operation.set(Operation.ADD);

        inputData.addListener(new ValueCachingChangeListener());

        initCalculateButtonState();

        status.set(Status.WAITING.toString());

    }

    public StringProperty inputDataProperty() {
        return inputData;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getStatus() {
        return status.get();
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

    public final ObservableList<Operation> getOperations() {
        return operations.get();
    }

    public boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    private IAction createActionByOperation(final Operation operation) {
        return ActionFactory.create(operation);
    }

    public void calculate() {
        if (isCalculationDisabled()) {
            return;
        }

        Operation currentOperation = getOperation();

        int resultExpression = createActionByOperation(
                currentOperation).calculate(inputDataProperty().get());

        result.set(Integer.toString(resultExpression));
        status.set(Status.SUCCESS.toString());

        StringBuilder message = new StringBuilder(LogMessages.CALCULATE_WAS_PRESSED);
        message.append("String: ").append(inputData.get())
                .append("; Default operation ").append(operation.get().toString())
                .append("; Result: ").append(result.get());
        logger.log(message.toString());
        updateLogs();
    }

    private Status getInputDataStatus() {
        Status inputStatus = Status.READY;
        if (inputData.get().equals("")) {
            inputStatus = Status.WAITING;
        }
        try {
            List<String> separatedNumbers =
                    StringCalculator.getSeparatedNumbersFromString(inputData.get());
            StringCalculator.checkAllNumbersAreValid(separatedNumbers);
        } catch (NotANumberException | NegativeNumberException e) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }

    private void updateLogs() {
        List<String> fullLog = logger.getLog();
        String record = new String("");
        for (String log : fullLog) {
            record += log + "\n";
        }
        logs.set(record);
    }

    private void initCalculateButtonState() {
        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(inputData);
            }
            @Override
            protected boolean computeValue() {
                return getInputDataStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());
    }

    private class ValueCachingChangeListener implements ChangeListener<String> {
        private String prevValue = new String("");
        private String curValue = new String("");
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            if (oldValue.equals(newValue)) {
                return;
            }
            status.set(getInputDataStatus().toString());
            curValue = newValue;
        }
        public boolean isChanged() {
            return !prevValue.equals(curValue);
        }
        public void cache() {
            prevValue = curValue;
        }
    }

}

enum Status {
    WAITING("Please input input data"),
    READY("Press 'Calculate' Button"),
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

final class LogMessages {
    public static final String CALCULATE_WAS_PRESSED = "Calculate. ";
    public static final String EDITING_FINISHED = "Updated input. ";

    private LogMessages() { }
}
