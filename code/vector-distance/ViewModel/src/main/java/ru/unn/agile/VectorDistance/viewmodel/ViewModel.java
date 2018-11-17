package ru.unn.agile.VectorDistance.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.VectorDistance.model.FloatVector;
import ru.unn.agile.VectorDistance.model.VectorDistance;
import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewModel {
    private static final String DEFAULT_DELIMITER = " ";
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

    private static List<String> getNumbersArrayFromString(final String numbersString) {
        return Arrays.asList(numbersString.split(DEFAULT_DELIMITER));
    }

    private float[] getFloatArrayFromStringList(final List<String> stringList) {
        float[] floatArray = new float[stringList.size()];

        int i = 0;

        for (String number : stringList) {
            floatArray[i++] = Float.parseFloat(number);
        }
        return floatArray;
    }

    private FloatVector getVectorFromInputString(final String inputString) {
        List<String> singleNumbers = getNumbersArrayFromString(inputString);
        return new FloatVector(getFloatArrayFromStringList(singleNumbers));
    }

    public void calculate() {

        FloatVector a = getVectorFromInputString(vectorX.get());
        FloatVector b = getVectorFromInputString(vectorY.get());

        result.set(String.valueOf(distance.get().apply(a, b)));
        status.set(Status.SUCCESS.toString());
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
