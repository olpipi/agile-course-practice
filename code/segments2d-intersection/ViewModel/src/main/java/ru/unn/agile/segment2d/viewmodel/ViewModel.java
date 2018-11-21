package ru.unn.agile.segment2d.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.segment2d.model.Segment2D;

public class ViewModel {
    private static final String SEGMENT_ERROR_STATUS = "Segment is incorrect!";

    private StringProperty firstSegmentFirstPointCoordX = new SimpleStringProperty();
    private StringProperty firstSegmentFirstPointCoordY = new SimpleStringProperty();
    private StringProperty firstSegmentSecondPointCoordX = new SimpleStringProperty();
    private StringProperty firstSegmentSecondPointCoordY = new SimpleStringProperty();

    private StringProperty secondSegmentFirstPointCoordX = new SimpleStringProperty();
    private StringProperty secondSegmentFirstPointCoordY = new SimpleStringProperty();
    private StringProperty secondSegmentSecondPointCoordX = new SimpleStringProperty();
    private StringProperty secondSegmentSecondPointCoordY = new SimpleStringProperty();

    private StringProperty firstSegmentStatus = new SimpleStringProperty();
    private StringProperty secondSegmentStatus = new SimpleStringProperty();

    private StringProperty result = new SimpleStringProperty();

    public StringProperty firstSegmentFirstPointCoordX() { return firstSegmentFirstPointCoordX; }
    public String getFirstSegmentFirstPointCoordX() { return firstSegmentFirstPointCoordX.get(); }
    public void setFirstSegmentFirstPointCoordX(final String coordX) {
        firstSegmentFirstPointCoordX.set(coordX);
        checkIsFirstSegmentValid();
    }

    public StringProperty firstSegmentFirstPointCoordY() { return firstSegmentFirstPointCoordY; }
    public String getFirstSegmentFirstPointCoordY() { return firstSegmentFirstPointCoordY.get(); }
    public void setFirstSegmentFirstPointCoordY(final String coordY) {
        firstSegmentFirstPointCoordY.set(coordY);
        checkIsFirstSegmentValid();
    }

    public StringProperty firstSegmentSecondPointCoordX() { return firstSegmentSecondPointCoordX; }
    public String getFirstSegmentSecondPointCoordX() { return firstSegmentSecondPointCoordX.get(); }
    public void setFirstSegmentSecondPointCoordX(final String coordX) {
        firstSegmentSecondPointCoordX.set(coordX);
        checkIsFirstSegmentValid();
    }

    public StringProperty firstSegmentSecondPointCoordY() { return firstSegmentSecondPointCoordY; }
    public String getFirstSegmentSecondPointCoordY() { return firstSegmentSecondPointCoordY.get(); }
    public void setFirstSegmentSecondPointCoordY(final String coordY) {
        firstSegmentSecondPointCoordY.set(coordY);
        checkIsFirstSegmentValid();
    }

    public StringProperty secondSegmentFirstPointCoordX() { return secondSegmentFirstPointCoordX; }
    public String getSecondSegmentFirstPointCoordX() { return secondSegmentFirstPointCoordX.get(); }
    public void setSecondSegmentFirstPointCoordX(final String coordX) {
        secondSegmentFirstPointCoordX.set(coordX);
        checkIsSecondSegmentValid();
    }

    public StringProperty secondSegmentFirstPointCoordY() { return secondSegmentFirstPointCoordY; }
    public String getSecondSegmentFirstPointCoordY() { return secondSegmentFirstPointCoordY.get(); }
    public void setSecondSegmentFirstPointCoordY(final String coordY) {
        secondSegmentFirstPointCoordY.set(coordY);
        checkIsSecondSegmentValid();
    }

    public StringProperty secondSegmentSecondPointCoordX() { return secondSegmentSecondPointCoordX; }
    public String getSecondSegmentSecondPointCoordX() { return secondSegmentSecondPointCoordX.get(); }
    public void setSecondSegmentSecondPointCoordX(final String coordX) {
        secondSegmentSecondPointCoordX.set(coordX);
        checkIsSecondSegmentValid();
    }

    public StringProperty secondSegmentSecondPointCoordY() { return secondSegmentSecondPointCoordY; }
    public String getSecondSegmentSecondPointCoordY() { return secondSegmentSecondPointCoordY.get(); }
    public void setSecondSegmentSecondPointCoordY(final String coordY) {
        secondSegmentSecondPointCoordY.set(coordY);
        checkIsSecondSegmentValid();
    }

    public StringProperty firstSegmentStatus() { return firstSegmentStatus; }
    public String getFirstSegmentStatus() { return firstSegmentStatus.get(); }

    public StringProperty secondSegmentStatus() { return secondSegmentStatus; }
    public String getSecondSegmentStatus() { return secondSegmentStatus.get(); }

    public StringProperty result() { return result; }
    public String getResult() { return result.get(); }

    public ViewModel() {
        init();
    }

    private void init() {
        firstSegmentFirstPointCoordX.set("");
        firstSegmentFirstPointCoordY.set("");
        firstSegmentSecondPointCoordX.set("");
        firstSegmentSecondPointCoordY.set("");
        secondSegmentFirstPointCoordX.set("");
        secondSegmentFirstPointCoordY.set("");
        secondSegmentSecondPointCoordX.set("");
        secondSegmentSecondPointCoordY.set("");
        firstSegmentStatus.set("");
        secondSegmentStatus.set("");
        result.set("");
    }

    private void checkCoordCanBeParsedToDouble(String coord, StringProperty status) {
        double parsedCoord;
        try {
            parsedCoord = Double.parseDouble(coord);
        } catch (NumberFormatException e) {
            status.set(SEGMENT_ERROR_STATUS);
        }
    }

    private void checkIsFirstSegmentValid() {
        checkCoordCanBeParsedToDouble(firstSegmentFirstPointCoordX.get(), firstSegmentStatus);
        checkCoordCanBeParsedToDouble(firstSegmentFirstPointCoordY.get(), firstSegmentStatus);
        checkCoordCanBeParsedToDouble(firstSegmentSecondPointCoordX.get(), firstSegmentStatus);
        checkCoordCanBeParsedToDouble(firstSegmentSecondPointCoordY.get(), firstSegmentStatus);
    }

    private void checkIsSecondSegmentValid() {
        checkCoordCanBeParsedToDouble(secondSegmentFirstPointCoordX.get(), secondSegmentStatus);
        checkCoordCanBeParsedToDouble(secondSegmentFirstPointCoordY.get(), secondSegmentStatus);
        checkCoordCanBeParsedToDouble(secondSegmentSecondPointCoordX.get(), secondSegmentStatus);
        checkCoordCanBeParsedToDouble(secondSegmentSecondPointCoordY.get(), secondSegmentStatus);
    }
}