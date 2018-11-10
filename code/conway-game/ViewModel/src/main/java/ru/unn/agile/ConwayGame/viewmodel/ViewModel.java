package ru.unn.agile.ConwayGame.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private final StringProperty rowsCount = new SimpleStringProperty();
    private final StringProperty columnsCount = new SimpleStringProperty();

    private final StringProperty input = new SimpleStringProperty();
    private final StringProperty output = new SimpleStringProperty();

    private final StringProperty status = new SimpleStringProperty();

    public ViewModel() {
        rowsCount.set("");
        columnsCount.set("");

        input.set("Input:");
        output.set("Output:");
        status.set(Status.WAITING.toString());
    }

    public StringProperty rowsCountProperty() {
        return rowsCount;
    }
    public StringProperty columnsCountProperty() {
        return columnsCount;
    }

    public StringProperty inputProperty() {
        return input;
    }
    public StringProperty outputProperty() {
        return output;
    }

    public StringProperty statusProperty() {
        return status;
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Create a grid!' or Enter"),
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
