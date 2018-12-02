package ru.unn.agile.intersect.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.intersect.model.LineIntersectPlane;

public class ViewModel {
    private StringProperty coordXFirstPlanePoint = new SimpleStringProperty();
    private StringProperty coordYFirstPlanePoint = new SimpleStringProperty();
    private StringProperty coordZFirstPlanePoint = new SimpleStringProperty();

    private StringProperty coordXSecondPlanePoint = new SimpleStringProperty();
    private StringProperty coordYSecondPlanePoint = new SimpleStringProperty();
    private StringProperty coordZSecondPlanePoint = new SimpleStringProperty();

    private StringProperty coordXThirdPlanePoint = new SimpleStringProperty();
    private StringProperty coordYThirdPlanePoint = new SimpleStringProperty();
    private StringProperty coordZThirdPlanePoint = new SimpleStringProperty();

    private StringProperty coordXFirstLinePoint = new SimpleStringProperty();
    private StringProperty coordYFirstLinePoint = new SimpleStringProperty();
    private StringProperty coordZFirstLinePoint = new SimpleStringProperty();

    private StringProperty coordXSecondLinePoint = new SimpleStringProperty();
    private StringProperty coordYSecondLinePoint = new SimpleStringProperty();
    private StringProperty coordZSecondLinePoint = new SimpleStringProperty();

    private StringProperty result = new SimpleStringProperty();

    public ViewModel() {
        init();
    }

    private void init() {
        coordXFirstPlanePoint.set("");
        coordYFirstPlanePoint.set("");
        coordZFirstPlanePoint.set("");

        coordXSecondPlanePoint.set("");
        coordYSecondPlanePoint.set("");
        coordZSecondPlanePoint.set("");

        coordXThirdPlanePoint.set("");
        coordYThirdPlanePoint.set("");
        coordZThirdPlanePoint.set("");

        coordXFirstLinePoint.set("");
        coordYFirstLinePoint.set("");
        coordZFirstLinePoint.set("");

        coordXSecondLinePoint.set("");
        coordYSecondLinePoint.set("");
        coordZSecondLinePoint.set("");

        result.set("");
    }

    public void setCoordXFirstPlanePoint(String coordXFirstPlanePoint) {
        this.coordXFirstPlanePoint.set(coordXFirstPlanePoint);
    }

    public void setCoordYFirstPlanePoint(String coordYFirstPlanePoint) {
        this.coordYFirstPlanePoint.set(coordYFirstPlanePoint);
    }

    public void setCoordZFirstPlanePoint(String coordZFirstPlanePoint) {
        this.coordZFirstPlanePoint.set(coordZFirstPlanePoint);
    }

    public void setCoordXSecondPlanePoint(String coordXSecondPlanePoint) {
        this.coordXSecondPlanePoint.set(coordXSecondPlanePoint);
    }

    public void setCoordYSecondPlanePoint(String coordYSecondPlanePoint) {
        this.coordYSecondPlanePoint.set(coordYSecondPlanePoint);
    }

    public void setCoordZSecondPlanePoint(String coordZSecondPlanePoint) {
        this.coordZSecondPlanePoint.set(coordZSecondPlanePoint);
    }

    public void setCoordXThirdPlanePoint(String coordXThirdPlanePoint) {
        this.coordXThirdPlanePoint.set(coordXThirdPlanePoint);
    }

    public void setCoordYThirdPlanePoint(String coordYThirdPlanePoint) {
        this.coordYThirdPlanePoint.set(coordYThirdPlanePoint);
    }

    public void setCoordZThirdPlanePoint(String coordZThirdPlanePoint) {
        this.coordZThirdPlanePoint.set(coordZThirdPlanePoint);
    }

    public void setCoordXFirstLinePoint(String coordXFirstLinePoint) {
        this.coordXFirstLinePoint.set(coordXFirstLinePoint);
    }

    public void setCoordYFirstLinePoint(String coordYFirstLinePoint) {
        this.coordYFirstLinePoint.set(coordYFirstLinePoint);
    }

    public void setCoordZFirstLinePoint(String coordZFirstLinePoint) {
        this.coordZFirstLinePoint.set(coordZFirstLinePoint);
    }

    public void setCoordXSecondLinePoint(String coordXSecondLinePoint) {
        this.coordXSecondLinePoint.set(coordXSecondLinePoint);
    }

    public void setCoordYSecondLinePoint(String coordYSecondLinePoint) {
        this.coordYSecondLinePoint.set(coordYSecondLinePoint);
    }

    public void setCoordZSecondLinePoint(String coordZSecondLinePoint) {
        this.coordZSecondLinePoint.set(coordZSecondLinePoint);
    }

    public String getCoordXFirstPlanePoint() {
        return coordXFirstPlanePoint.get();
    }

    public String getCoordYFirstPlanePoint() {
        return coordYFirstPlanePoint.get();
    }

    public String getCoordZFirstPlanePoint() {
        return coordZFirstPlanePoint.get();
    }

    public String getCoordXSecondPlanePoint() {
        return coordXSecondPlanePoint.get();
    }

    public String getCoordYSecondPlanePoint() {
        return coordYSecondPlanePoint.get();
    }

    public String getCoordZSecondPlanePoint() {
        return coordZSecondPlanePoint.get();
    }

    public String getCoordXThirdPlanePoint() {
        return coordXThirdPlanePoint.get();
    }

    public String getCoordYThirdPlanePoint() {
        return coordYThirdPlanePoint.get();
    }

    public String getCoordZThirdPlanePoint() {
        return coordZThirdPlanePoint.get();
    }

    public String getCoordXFirstLinePoint() {
        return coordXFirstLinePoint.get();
    }

    public String getCoordYFirstLinePoint() {
        return coordYFirstLinePoint.get();
    }

    public String getCoordZFirstLinePoint() {
        return coordZFirstLinePoint.get();
    }

    public String getCoordXSecondLinePoint() {
        return coordXSecondLinePoint.get();
    }

    public String getCoordYSecondLinePoint() {
        return coordYSecondLinePoint.get();
    }

    public String getCoordZSecondLinePoint() {
        return coordZSecondLinePoint.get();
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty getCoordXFirstPlanePointProperty() {
        return coordXFirstPlanePoint;
    }

    public StringProperty getCoordYFirstPlanePointProperty() {
        return coordYFirstPlanePoint;
    }

    public StringProperty getCoordZFirstPlanePointProperty() {
        return coordZFirstPlanePoint;
    }

    public StringProperty getCoordXSecondPlanePointProperty() {
        return coordXSecondPlanePoint;
    }

    public StringProperty getCoordYSecondPlanePointProperty() {
        return coordYSecondPlanePoint;
    }

    public StringProperty getCoordZSecondPlanePointProperty() {
        return coordZSecondPlanePoint;
    }

    public StringProperty getCoordXThirdPlanePointProperty() {
        return coordXThirdPlanePoint;
    }

    public StringProperty getCoordYThirdPlanePointProperty() {
        return coordYThirdPlanePoint;
    }

    public StringProperty getCoordZThirdPlanePointProperty() {
        return coordZThirdPlanePoint;
    }

    public StringProperty getCoordXFirstLinePointProperty() {
        return coordXFirstLinePoint;
    }

    public StringProperty getCoordYFirstLinePointProperty() {
        return coordYFirstLinePoint;
    }

    public StringProperty getCoordZFirstLinePointProperty() {
        return coordZFirstLinePoint;
    }

    public StringProperty getCoordXSecondLinePointProperty() {
        return coordXSecondLinePoint;
    }

    public StringProperty getCoordYSecondLinePointProperty() {
        return coordYSecondLinePoint;
    }

    public StringProperty getCoordZSecondLinePointProperty() {
        return coordZSecondLinePoint;
    }

    public StringProperty getResultProperty() {
        return result;
    }
}
