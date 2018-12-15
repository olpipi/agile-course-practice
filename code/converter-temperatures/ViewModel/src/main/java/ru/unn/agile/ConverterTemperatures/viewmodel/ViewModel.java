package ru.unn.agile.ConverterTemperatures.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesUnit;

public class ViewModel {
    private final StringProperty convertFrom = new SimpleStringProperty();
    private final StringProperty convertTo = new SimpleStringProperty();

    private final ObjectProperty<TemperaturesUnit> scale =
        new SimpleObjectProperty<TemperaturesUnit>();

    private final StringProperty status = new SimpleStringProperty();

    public ViewModel() {
        convertFrom.set("");
        convertTo.set("");
        scale.set(TemperaturesUnit.FAHRENHEIT);
        status.set(Status.READY.toString());
    }

    public StringProperty convertFromProperty() {
        return convertFrom;
    }
    public StringProperty convertToProperty() {
        return convertTo;
    }

    public TemperaturesUnit getScale() {
        return scale.get();
    }

    public StringProperty statusProperty() {
        return status;
    }
    public final String getStatus() {
        return status.get();
    }

    public void updateInputValues() {
        if (convertFrom.get().isEmpty()) {
            status.set(Status.WAITING.toString());
        }
        try {
            if (!convertFrom.get().isEmpty()) {
                Double.parseDouble(convertFrom.get());
            }
            status.set(Status.READY.toString());
        } catch (NumberFormatException nfe) {
            status.set(Status.BAD_FORMAT.toString());
        }

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
