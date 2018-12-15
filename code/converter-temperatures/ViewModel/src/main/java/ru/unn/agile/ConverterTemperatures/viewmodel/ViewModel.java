package ru.unn.agile.ConverterTemperatures.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesConverter;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesConverterExceptions;
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
    public final String getConvertTo() {
        return convertTo.get();
    }

    public ObjectProperty<TemperaturesUnit> scaleProperty() {
        return scale;
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

    public void checkInputValues() {
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

    public void convert() {
        checkInputValues();
        try {
            double result = TemperaturesConverter.convert(convertFrom.get(), scale.get());
            convertTo.set(String.valueOf(result));
            status.set(Status.SUCCESS.toString());
        } catch (TemperaturesConverterExceptions ex) {
            status.set(Status.ERROR.toString());
        }
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Convert' or Enter"),
    BAD_FORMAT("Bad format"),
    ERROR("Converting error"),
    SUCCESS("Success");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
