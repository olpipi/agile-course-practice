package ru.unn.agile.dijkstra.viewModel;

import javafx.beans.property.*;

public class ViewModel {

    private final StringProperty matrix = new SimpleStringProperty();
    private final StringProperty startVertex = new SimpleStringProperty();
    private final StringProperty finishVertex = new SimpleStringProperty();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    public void calculate() {

    }

    public StringProperty matrixProperty() {
        return matrix;
    }

    public StringProperty startVertexProperty() {
        return startVertex;
    }

    public StringProperty finishVertexProperty() {
        return finishVertex;
    }

    public String getResult() {
        return result.get();
    }

    public String getStatus() {
        return status.get();
    }

    public boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }
}
