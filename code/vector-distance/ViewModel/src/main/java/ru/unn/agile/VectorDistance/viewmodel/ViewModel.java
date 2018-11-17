package ru.unn.agile.VectorDistance.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;

public class ViewModel {
    private final StringProperty vectorX = new SimpleStringProperty();
    private final StringProperty vectorY = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final ObjectProperty<ObservableList<Distance>> distances =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Distance.values()));
    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    public final ObservableList<Distance> getDistances() {
        return distances.get();
    }

    private final ObjectProperty<Distance> distance = new SimpleObjectProperty<>();

    public ViewModel() {
        vectorX.set("");
        vectorY.set("");
        result.set("");
        status.set(Status.WAITING.toString());
        distance.set(Distance.L1);
        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(vectorX, vectorY);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());
    }


    public void calculate() {

    }

    public ObjectProperty<Distance> distanceProperty() {
        return distance;
    }

    public StringProperty vectorXProperty() {
        return vectorX;
    }
    public StringProperty vectorYProperty() {
        return vectorY;
    }

    public StringProperty resultProperty() {
        return result;
    }
    public final String getResult() {
        return result.get();
    }
    public StringProperty statusProperty() {
        return status;
    }
    public final String getStatus() {
        return status.get();
    }
    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }
    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        return null;
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
