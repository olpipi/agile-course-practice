package ru.unn.agile.ConwayGame.viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import ru.unn.agile.ConwayGame.Model.ConwayGame;

public class ViewModel {
    private final StringProperty rowsNumber = new SimpleStringProperty();
    private final StringProperty columnsNumber = new SimpleStringProperty();
    private final StringProperty firstGeneration = new SimpleStringProperty();

    private final BooleanProperty creationGridDisabled = new SimpleBooleanProperty();
    private final BooleanProperty submitionDisabled = new SimpleBooleanProperty();

    private final StringProperty input = new SimpleStringProperty();
    private final StringProperty output = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {
        rowsNumber.set("");
        columnsNumber.set("");
        firstGeneration.set("");

        input.set("Input:");
        output.set("Output:");
        status.set(Status.WAITING.toString());

        BooleanBinding couldCreateGrid = new BooleanBinding() {
            {
                super.bind(rowsNumber, columnsNumber);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY_TO_SET;
            }
        };
        creationGridDisabled.bind(couldCreateGrid.not());

        final List<StringProperty> sizes = new ArrayList<StringProperty>() { {
            add(rowsNumber);
            add(columnsNumber);
        } };

        for (StringProperty size : sizes) {
            final ValueChangeListener listener = new ValueChangeListener();
            size.addListener(listener);
            valueChangedListeners.add(listener);
        }

        BooleanBinding couldSubmit = new BooleanBinding() {
            {
                super.bind(firstGeneration);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        submitionDisabled.bind(couldSubmit.not());

        final List<StringProperty> fields = new ArrayList<StringProperty>() { {
            add(firstGeneration);
        } };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    public void calculateNextGeneration() {
        if (creationGridDisabled.get()) {
            return;
        }
        int rows = Integer.parseInt(rowsNumber.get());
        int columns = Integer.parseInt(columnsNumber.get());

        ConwayGame game = new ConwayGame(rows, columns);
        game.setGeneration(firstGenerationProperty().getValue());
        game.moveToNextGeneration();

        status.set(Status.SUCCESS.toString());
    }

    public StringProperty rowsNumberProperty() {
        return rowsNumber;
    }
    public StringProperty columnsNumberProperty() {
        return columnsNumber;
    }
    public StringProperty firstGenerationProperty() {
        return firstGeneration;
    }

    public BooleanProperty creationGridDisabledProperty() {
        return creationGridDisabled;
    }
    public final boolean isCreationGridDisabled() {
        return creationGridDisabled.get();
    }
    public BooleanProperty submitionDisabledProperty() {
        return submitionDisabled;
    }
    public final boolean isSubmitionDisabled() {
        return submitionDisabled.get();
    }

    public StringProperty inputProperty() {
        return input;
    }
    public final String getInput() {
        return input.get();
    }
    public StringProperty outputProperty() {
        return output;
    }
    public final String getOutput() {
        return output.get();
    }

    public StringProperty statusProperty() {
        return status;
    }
    public final String getStatus() {
        return status.get();
    }

    private String convertToGeneration(final StringProperty incomingGeneration) {
        String str = incomingGeneration.getValue();

        Pattern pattern = Pattern.compile("^[.*]+$");
        Matcher matcher = pattern.matcher(str);
        matcher.find();

        return matcher.group(0);
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (rowsNumber.get().isEmpty() || columnsNumber.get().isEmpty()
                || firstGeneration.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }
        if (firstGeneration.get().isEmpty() && !rowsNumber.get().isEmpty()
                && !columnsNumber.get().isEmpty()) {
            inputStatus = Status.READY_TO_SET;
        }
        if (!rowsNumber.get().isEmpty() && !columnsNumber.get().isEmpty()
                && !firstGeneration.get().isEmpty()) {
            int rows = Integer.parseInt(rowsNumberProperty().get());
            int columns = Integer.parseInt(columnsNumberProperty().get());
            int size = rows * columns;

            if (firstGeneration.length().intValue() < size) {
                inputStatus = Status.READY_TO_SET;
            }
            if (firstGeneration.length().intValue() > size) {
                inputStatus = Status.BAD_FORMAT;
            }
        }
        try {
            if (!rowsNumber.get().isEmpty()) {
                Integer.parseInt(rowsNumber.get());
            }
            if (!columnsNumber.get().isEmpty()) {
                Integer.parseInt(columnsNumber.get());
            }
            if (!firstGeneration.get().isEmpty()) {
                convertToGeneration(firstGeneration);
            }
        } catch (NumberFormatException | IllegalStateException exc) {
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
}

enum Status {
    WAITING("Please provide input data"),
    READY_TO_SET("Provide a generation"),
    READY("Press 'Submit!' "),
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
