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
    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

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

        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(firstNumerator, firstDenominator,
                        secondNumerator, secondDenominator);
            }

            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());

        final List<StringProperty> fields = new ArrayList<StringProperty>() {
            {
                add(firstNumerator);
                add(firstDenominator);
                add(secondNumerator);
                add(secondDenominator);
            }
        };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    public String getFirstNumerator() {
        return firstNumerator.get();
    }

    public void setFirstNumerator(final String newfirstNumerator) {
        firstNumerator.set(newfirstNumerator);
    }

    public StringProperty firstNumeratorProperty() {
        return firstNumerator;
    }

    public String getFirstDenominator() {
        return firstDenominator.get();
    }

    public void setFirstDenominator(final String newfirstDenominator) {
        firstDenominator.set(newfirstDenominator);
    }

    public StringProperty firstDenominatorProperty() {
        return firstDenominator;
    }

    public String getSecondNumerator() {
        return secondNumerator.get();
    }

    public void setSecondNumerator(final String newSecondNumerator) {
        secondNumerator.set(newSecondNumerator);
    }

    public StringProperty secondNumeratorProperty() {
        return secondNumerator;
    }

    public String getSecondDenominator() {
        return secondDenominator.get();
    }

    public void setSecondDenominator(final String newSecondDenominator) {
        secondDenominator.set(newSecondDenominator);
    }

    public StringProperty secondDenominatorProperty() {
        return secondDenominator;
    }

    public String getResultNumerator() {
        return resultNumerator.get();
    }

    public void setResultNumerator(final String newResultNumerator) {
        resultNumerator.set(newResultNumerator);
    }

    public StringProperty resultNumeratorProperty() {
        return resultNumerator;
    }

    public String getResultDenominator() {
        return resultDenominator.get();
    }

    public void setResultDenominator(final String newResultDenominator) {
        resultDenominator.set(newResultDenominator);
    }

    public StringProperty resultDenominatorProperty() {
        return resultDenominator;
    }

    public ObjectProperty<ObservableList<Operation>> operationsProperty() {
        return operations;
    }

    public final ObservableList<Operation> getOperations() {
        return operations.get();
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }

    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public final String getStatus() {
        return status.get();
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;

        if (firstNumerator.get().isEmpty() || firstDenominator.get().isEmpty()
                || secondNumerator.get().isEmpty() || secondDenominator.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }

        try {
            if (!firstNumerator.get().isEmpty()) {
                Integer.parseInt(firstNumerator.get());
            }
            if (!firstDenominator.get().isEmpty()) {
                Integer.parseInt(firstDenominator.get());
            }
            if (!secondNumerator.get().isEmpty()) {
                Integer.parseInt(secondNumerator.get());
            }
            if (!secondDenominator.get().isEmpty()) {
                Integer.parseInt(secondDenominator.get());
            }
        } catch (NumberFormatException nfe) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
        }
    }

    public void calculate() {
        if (calculationDisabled.get()) {
            return;
        }

        Fraction f1 = new Fraction(Integer.parseInt(firstNumerator.get()),
                Integer.parseInt(firstDenominator.get()));
        Fraction f2 = new Fraction(Integer.parseInt(secondNumerator.get()),
                Integer.parseInt(secondDenominator.get()));
        Fraction res = operation.get().apply(f1, f2);

        resultNumerator.set(String.valueOf(res.getNumerator()));
        resultDenominator.set(String.valueOf(res.getDenominator()));
        status.set(Status.SUCCESS.toString());
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
