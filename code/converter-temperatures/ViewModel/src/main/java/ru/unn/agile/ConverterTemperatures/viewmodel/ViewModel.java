package ru.unn.agile.ConverterTemperatures.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.ConverterTemperatures.model.*;

import java.util.List;

public class ViewModel {
    private static final String EMPTY_STRING = "";
    private final StringProperty convertFrom = new SimpleStringProperty();
    private final StringProperty convertTo = new SimpleStringProperty();
    private final StringProperty log = new SimpleStringProperty();

    private ILogger logger;

    private final ObjectProperty<ObservableList<TemperaturesUnit>> scales =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(TemperaturesUnit.values()));
    private final ObjectProperty<TemperaturesUnit> unit =
            new SimpleObjectProperty<TemperaturesUnit>();

    private final StringProperty status = new SimpleStringProperty();

    public List<String> getLogList() {
        return logger.getLog();
    }

    public String getLog() {
        return log.get();
    }

    public StringProperty logProperty() {
        return log;
    }

    public ViewModel() {
        init();
    }

    public ViewModel(final ILogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger can't be null");
        }
        this.logger = logger;
        init();
    }

    private void init() {
        convertFrom.set("");
        convertTo.set("");
        unit.set(TemperaturesUnit.FAHRENHEIT);
        status.set(Status.READY.toString());
        log.set(EMPTY_STRING);
    }

    private void addLog(String s) {
        logger.log(s);
        StringBuilder logMsg = new StringBuilder();
        for (String line : logger.getLog()) {
            logMsg.append(line).append("\n");
        }
        log.set(logMsg.toString());
    }

    public StringProperty convertFromProperty() {
        return convertFrom;
    }

    public StringProperty convertToProperty() {
        return convertTo;
    }

    public final String getConvertTo() {
        return convertTo.get();
    }

    public final String getConvertFrom() {
        return convertFrom.get();
    }

    public ObjectProperty<ObservableList<TemperaturesUnit>> scalesProperty() {
        return scales;
    }

    public final ObservableList<TemperaturesUnit> getScales() {
        return scales.get();
    }

    public ObjectProperty<TemperaturesUnit> scaleProperty() {
        return unit;
    }

    public TemperaturesUnit getScale() {
        return unit.get();
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
                status.set(Status.READY.toString());
            }
        } catch (NumberFormatException nfe) {
            addLog(String.format(LogMessage.VALUE_FROM_IS_NOT_CORRECT, convertFrom.get()));
            status.set(Status.BAD_FORMAT.toString());
        }
    }

    public void convert() {
        checkInputValues();
        if (status.get() != Status.READY.toString()) {
            return;
        }

        try {
            double valueToConvert = Double.parseDouble(convertFrom.get());
            double result = TemperaturesConverter.convert(valueToConvert, unit.get());

            addLog(String.format(LogMessage.CONVERT_WAS_PRESSED,
                    valueToConvert, "°C", result, unit.get()));

            convertTo.set(String.valueOf(result));
            status.set(Status.SUCCESS.toString());
        } catch (TemperaturesConverterExceptions ex) {
            addLog(String.format(LogMessage.VALUE_FROM_IS_NOT_CORRECT, convertFrom.get()));
            status.set(Status.ERROR.toString());
        }
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Convert' or Enter"),
    BAD_FORMAT("Bad format"),
    ERROR("Converting error: input value out of range"),
    SUCCESS("Success");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
