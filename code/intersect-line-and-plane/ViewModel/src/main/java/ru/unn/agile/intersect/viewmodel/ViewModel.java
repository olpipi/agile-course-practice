package ru.unn.agile.intersect.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.unn.agile.intersect.model.LineIntersectPlane;
import ru.unn.agile.intersect.model.objects.*;

public class ViewModel {
    private static final String WAITING_STATUS = "Waiting for input";
    private static final String OK_STATUS = "Correct input";

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

    private StringProperty planeStatus = new SimpleStringProperty();
    private StringProperty lineStatus = new SimpleStringProperty();
    private StringProperty result = new SimpleStringProperty();

    public ViewModel() {
        initCoordinatesAndResult();
        initStatuses();
    }

    private void initCoordinatesAndResult() {
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

    private void initStatuses() {
        planeStatus.set(WAITING_STATUS);
        lineStatus.set(WAITING_STATUS);
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

    public String getPlaneStatus() {
        return planeStatus.get();
    }

    public String getLineStatus() {
        return lineStatus.get();
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

    public StringProperty getPlaneStatusProperty() {
        return planeStatus;
    }

    public StringProperty getLineStatusProperty() {
        return lineStatus;
    }

    public StringProperty getResultProperty() {
        return result;
    }

    public Map<String, List<Double>> createPlaneCoordMap() {
        Map<String, List<Double>> result = new HashMap<String, List<Double>>();

        List<Double> coordinatesA = new ArrayList<Double>();
        List<Double> coordinatesB = new ArrayList<Double>();
        List<Double> coordinatesC = new ArrayList<Double>();

        coordinatesA.add(Double.valueOf(coordXFirstPlanePoint.get()));
        coordinatesA.add(Double.valueOf(coordYFirstPlanePoint.get()));
        coordinatesA.add(Double.valueOf(coordZFirstPlanePoint.get()));

        coordinatesB.add(Double.valueOf(coordXSecondPlanePoint.get()));
        coordinatesB.add(Double.valueOf(coordYSecondPlanePoint.get()));
        coordinatesB.add(Double.valueOf(coordZSecondPlanePoint.get()));

        coordinatesC.add(Double.valueOf(coordXThirdPlanePoint.get()));
        coordinatesC.add(Double.valueOf(coordYThirdPlanePoint.get()));
        coordinatesC.add(Double.valueOf(coordZThirdPlanePoint.get()));

        result.put("A", coordinatesA);
        result.put("B", coordinatesB);
        result.put("C", coordinatesC);

        return result;
    }

    public Map<String, List<Double>> createLineCoordMap() {
        Map<String, List<Double>> result = new HashMap<String, List<Double>>();

        List<Double> coordinatesX = new ArrayList<Double>();
        List<Double> coordinatesY = new ArrayList<Double>();

        coordinatesX.add(Double.valueOf(coordXFirstLinePoint.get()));
        coordinatesX.add(Double.valueOf(coordYFirstLinePoint.get()));
        coordinatesX.add(Double.valueOf(coordZFirstLinePoint.get()));

        coordinatesY.add(Double.valueOf(coordXSecondLinePoint.get()));
        coordinatesY.add(Double.valueOf(coordYSecondLinePoint.get()));
        coordinatesY.add(Double.valueOf(coordZSecondLinePoint.get()));

        result.put("X", coordinatesX);
        result.put("Y", coordinatesY);

        return result;
    }

    public Plane createPlane() {
        Map<String, List<Double>> planeCoordinates = createPlaneCoordMap();

        Point pointA = new Point(planeCoordinates.get("A").get(0), planeCoordinates.get("A").get(1), planeCoordinates.get("A").get(2));
        Point pointB = new Point(planeCoordinates.get("B").get(0), planeCoordinates.get("B").get(1), planeCoordinates.get("B").get(2));
        Point pointC = new Point(planeCoordinates.get("C").get(0), planeCoordinates.get("C").get(1), planeCoordinates.get("C").get(2));

        Plane plane = new Plane(pointA, pointB, pointC);
        if (plane != null) {
            planeStatus.set(OK_STATUS);
        }

        return new Plane(pointA, pointB, pointC);
    }

    public Line createLine() {
        Map<String, List<Double>> lineCoordinates = createLineCoordMap();

        Point pointX = new Point(lineCoordinates.get("X").get(0), lineCoordinates.get("X").get(1), lineCoordinates.get("X").get(2));
        Point pointY = new Point(lineCoordinates.get("Y").get(0), lineCoordinates.get("Y").get(1), lineCoordinates.get("Y").get(2));

        Line line = new Line(pointX, pointY);
        if (line != null) {
            lineStatus.set(OK_STATUS);
        }

        return line;
    }
}
