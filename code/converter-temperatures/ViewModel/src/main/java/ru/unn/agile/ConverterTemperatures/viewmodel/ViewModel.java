package ru.unn.agile.ConverterTemperatures.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesUnit;

public class ViewModel {
    private final StringProperty convertFrom = new SimpleStringProperty();
    private final StringProperty convertTo = new SimpleStringProperty();

    //private final ObjectProperty<ObservableList<TemperaturesUnit>> scales =
    //    new SimpleObjectProperty<>(FXCollections.observableArrayList(TemperaturesUnit.values()));
    private final ObjectProperty<TemperaturesUnit> scale =
        new SimpleObjectProperty<TemperaturesUnit>();

    private final StringProperty status = new SimpleStringProperty();

    public ViewModel() {
        convertFrom.set("");
        convertTo.set("");
        scale.set(TemperaturesUnit.FAHRENHEIT);
        status.set(Status.READY.toString());
    }

    public String getConvertFrom() {
        return convertFrom.get();
    }

    public TemperaturesUnit getScale() {
        return scale.get();
    }

    public String getConvertTo() {
        return convertTo.get();
    }

    public final String getStatus() {
        return status.get();
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Convert' or Enter"),
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
