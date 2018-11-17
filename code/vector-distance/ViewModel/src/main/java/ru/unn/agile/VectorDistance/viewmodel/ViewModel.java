package ru.unn.agile.VectorDistance.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.VectorDistance.model.VectorDistance;
import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;

public class ViewModel {

    private final ObjectProperty<ObservableList<Distance>> distances =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Distance.values()));

    public final ObservableList<Distance> getDistances() {
        return distances.get();
    }

    private final ObjectProperty<Distance> operation = new SimpleObjectProperty<>();

    public ObjectProperty<Distance> distanceProperty() {
        return operation;
    }
}
