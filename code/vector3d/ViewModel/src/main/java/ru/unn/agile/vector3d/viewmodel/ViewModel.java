package ru.unn.agile.vector3d.viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.vector3d.model.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final static String EMPTY_STRING = "";

    private final StringProperty vectorX = new SimpleStringProperty();
    private final StringProperty vectorY = new SimpleStringProperty();
    private final StringProperty vectorZ = new SimpleStringProperty();

    private final StringProperty otherVectorX = new SimpleStringProperty();
    private final StringProperty otherVectorY = new SimpleStringProperty();
    private final StringProperty otherVectorZ = new SimpleStringProperty();

    private final StringProperty multiplicationCoeff = new SimpleStringProperty();

    private final ObjectProperty<ObservableList<Vector3D.Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Vector3D.Operation.values()));
    private final ObjectProperty<Vector3D.Operation> operation = new SimpleObjectProperty<>();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public final ObservableList<Vector3D.Operation> getOperations() {
        return operations.get();
    }

    public StringProperty vectorXProperty() {
        return vectorX;
    }

    public StringProperty vectorYProperty() {
        return vectorY;
    }

    public StringProperty vectorZProperty() {
        return vectorZ;
    }

    public StringProperty otherVectorXProperty() {
        return otherVectorX;
    }

    public StringProperty otherVectorYProperty() {
        return otherVectorY;
    }

    public StringProperty otherVectorZProperty() {
        return otherVectorZ;
    }

    public StringProperty multiplicationCoeffProperty() {
        return multiplicationCoeff;
    }

    public ObjectProperty<Vector3D.Operation> operationProperty() {
        return operation;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public ViewModel() {
        setDefaultVector();
        setDefaultOtherVector();
        setDefaultMultCoeffAndResult();
        setDefaultOperationAndStatus();
    }

    private void setDefaultVector() {
        vectorX.set(EMPTY_STRING);
        vectorY.set(EMPTY_STRING);
        vectorZ.set(EMPTY_STRING);
    }

    private void setDefaultOtherVector() {
        otherVectorX.set(EMPTY_STRING);
        otherVectorY.set(EMPTY_STRING);
        otherVectorZ.set(EMPTY_STRING);
    }

    private void setDefaultMultCoeffAndResult() {
        multiplicationCoeff.set(EMPTY_STRING);
        result.set(EMPTY_STRING);
    }

    private void setDefaultOperationAndStatus() {
        operation.set(Vector3D.Operation.ADD);
        status.set(Status.WAITING.toString());
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
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
}
