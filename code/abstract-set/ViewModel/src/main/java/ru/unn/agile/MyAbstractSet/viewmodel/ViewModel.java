package ru.unn.agile.MyAbstractSet.viewmodel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.MyAbstractSet.Model.MyAbstractSet;

public class ViewModel {
    private final StringProperty firstSetTextArea = new SimpleStringProperty();
    private final StringProperty secondSetTextArea = new SimpleStringProperty();
    private final StringProperty resultTextArea = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final BooleanProperty executeButtonDisabled = new SimpleBooleanProperty();
    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));
    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final ValueChangeListener valueChangeListener = new ValueChangeListener();
    private static final String WHITESPACE_PATTERN = "\\s+";

    public ViewModel() {
        firstSetTextArea.setValue("");
        secondSetTextArea.setValue("");
        operation.setValue(Operation.UNITE);
        resultTextArea.setValue("");
        status.setValue(Status.WAITING.toString());
        executeButtonDisabled.setValue(true);

        firstSetTextArea.addListener(valueChangeListener);
        secondSetTextArea.addListener(valueChangeListener);
    }

    public StringProperty firstSetTextAreaProperty() {
        return firstSetTextArea;
    }

    public StringProperty secondSetTextAreaProperty() {
        return secondSetTextArea;
    }

    public StringProperty resultTextAreaProperty() {
        return resultTextArea;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public BooleanProperty executeButtonDisabledProperty() {
        return executeButtonDisabled;
    }

    public ObjectProperty<ObservableList<Operation>> operationsProperty() {
        return operations;
    }
    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public void executeUniteOrIntersect() {
        Object[] firstSet = firstSetTextArea.get().replaceAll(WHITESPACE_PATTERN, "").split(",");
        Object[] secondSet = secondSetTextArea.get().replaceAll(WHITESPACE_PATTERN, "").split(",");

        MyAbstractSet set1 = new MyAbstractSet(firstSet);
        MyAbstractSet set2 = new MyAbstractSet(secondSet);

        MyAbstractSet res = operation.get().apply(set1, set2);
        status.set(Status.SUCCESS.toString());
        resultTextArea.setValue(res.toString());
    }

    public Status getInputStatus() {
        String firstSet = firstSetTextArea.get();
        String secondSet = secondSetTextArea.get();
        if (firstSet.isEmpty() || secondSet.isEmpty()) {
            return Status.WAITING;
        } else {
            return Status.READY;
        }
    }

    private boolean canNotExecuteOperation() {
        return getInputStatus() != Status.READY;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
            executeButtonDisabled.set(canNotExecuteOperation());
        }
    }

    public enum Operation {
        UNITE("Unite") {
            public MyAbstractSet apply(final MyAbstractSet set1, final MyAbstractSet set2) {
                return set1.unite(set2);
            }
        },
        INTERSECT("Intersect") {
            public MyAbstractSet apply(final MyAbstractSet set1, final MyAbstractSet set2) {
                return set1.intersect(set2);
            }
        };

        private final String name;
        Operation(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public abstract MyAbstractSet apply(MyAbstractSet set1, MyAbstractSet set2);
    }
}

enum Status {
    WAITING("Waiting for input"),
    READY("Press 'result' button"),
    SUCCESS("Success");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
