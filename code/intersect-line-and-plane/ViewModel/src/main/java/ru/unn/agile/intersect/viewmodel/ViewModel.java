package ru.unn.agile.intersect.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ru.unn.agile.intersect.model.LineIntersectPlane;
import ru.unn.agile.intersect.model.objects.*;

public class ViewModel {
    private static final String WAITING_STATUS = "Waiting for input";
    private static final String OK_STATUS = "Correct input";
    private static final String ERROR_STATUS = "Input error";

    private static final String INTERSECT_STATUS = "Intersect";
    private static final String NOT_INTERSECT_STATUS = "Do not intersect";

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

    public void setCoordXFirstPlanePoint(final String coordXFirstPlanePoint) {
        this.coordXFirstPlanePoint.set(coordXFirstPlanePoint);
    }

    public void setCoordYFirstPlanePoint(final String coordYFirstPlanePoint) {
        this.coordYFirstPlanePoint.set(coordYFirstPlanePoint);
    }

    public void setCoordZFirstPlanePoint(final String coordZFirstPlanePoint) {
        this.coordZFirstPlanePoint.set(coordZFirstPlanePoint);
    }

    public void setCoordXSecondPlanePoint(final String coordXSecondPlanePoint) {
        this.coordXSecondPlanePoint.set(coordXSecondPlanePoint);
    }

    public void setCoordYSecondPlanePoint(final String coordYSecondPlanePoint) {
        this.coordYSecondPlanePoint.set(coordYSecondPlanePoint);
    }

    public void setCoordZSecondPlanePoint(final String coordZSecondPlanePoint) {
        this.coordZSecondPlanePoint.set(coordZSecondPlanePoint);
    }

    public void setCoordXThirdPlanePoint(final String coordXThirdPlanePoint) {
        this.coordXThirdPlanePoint.set(coordXThirdPlanePoint);
    }

    public void setCoordYThirdPlanePoint(final String coordYThirdPlanePoint) {
        this.coordYThirdPlanePoint.set(coordYThirdPlanePoint);
    }

    public void setCoordZThirdPlanePoint(final String coordZThirdPlanePoint) {
        this.coordZThirdPlanePoint.set(coordZThirdPlanePoint);
    }

    public void setCoordXFirstLinePoint(final String coordXFirstLinePoint) {
        this.coordXFirstLinePoint.set(coordXFirstLinePoint);
    }

    public void setCoordYFirstLinePoint(final String coordYFirstLinePoint) {
        this.coordYFirstLinePoint.set(coordYFirstLinePoint);
    }

    public void setCoordZFirstLinePoint(final String coordZFirstLinePoint) {
        this.coordZFirstLinePoint.set(coordZFirstLinePoint);
    }

    public void setCoordXSecondLinePoint(final String coordXSecondLinePoint) {
        this.coordXSecondLinePoint.set(coordXSecondLinePoint);
    }

    public void setCoordYSecondLinePoint(final String coordYSecondLinePoint) {
        this.coordYSecondLinePoint.set(coordYSecondLinePoint);
    }

    public void setCoordZSecondLinePoint(final String coordZSecondLinePoint) {
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

    public void formPlaneCrdList(final List<Double> a, final List<Double> b, final List<Double> c) {
        a.add(Double.valueOf(getCoordXFirstPlanePoint()));
        a.add(Double.valueOf(getCoordYFirstPlanePoint()));
        a.add(Double.valueOf(getCoordZFirstPlanePoint()));

        b.add(Double.valueOf(getCoordXSecondPlanePoint()));
        b.add(Double.valueOf(getCoordYSecondPlanePoint()));
        b.add(Double.valueOf(getCoordZSecondPlanePoint()));

        c.add(Double.valueOf(getCoordXThirdPlanePoint()));
        c.add(Double.valueOf(getCoordYThirdPlanePoint()));
        c.add(Double.valueOf(getCoordZThirdPlanePoint()));
    }

    public void formLineCrdList(final List<Double> x, final List<Double> y) {
        x.add(Double.valueOf(getCoordXFirstLinePoint()));
        x.add(Double.valueOf(getCoordYFirstLinePoint()));
        x.add(Double.valueOf(getCoordZFirstLinePoint()));

        y.add(Double.valueOf(getCoordXSecondLinePoint()));
        y.add(Double.valueOf(getCoordYSecondLinePoint()));
        y.add(Double.valueOf(getCoordZSecondLinePoint()));
    }

    public Plane createPlane() {
        List<Double> coordinatesA = new ArrayList<Double>();
        List<Double> coordinatesB = new ArrayList<Double>();
        List<Double> coordinatesC = new ArrayList<Double>();
        try {
            formPlaneCrdList(coordinatesA, coordinatesB, coordinatesC);
            Point pointA = new Point(coordinatesA.get(0), coordinatesA.get(1), coordinatesA.get(2));
            Point pointB = new Point(coordinatesB.get(0), coordinatesB.get(1), coordinatesB.get(2));
            Point pointC = new Point(coordinatesC.get(0), coordinatesC.get(1), coordinatesC.get(2));
            Plane plane = new Plane(pointA, pointB, pointC);
            planeStatus.set(OK_STATUS);
            return plane;
        } catch (NumberFormatException | ArithmeticException ex) {
            planeStatus.set(ERROR_STATUS + ": " + ex.getMessage().toLowerCase(Locale.ENGLISH));
            return null;
        }
    }

    public Line createLine() {
        List<Double> coordinatesX = new ArrayList<Double>();
        List<Double> coordinatesY = new ArrayList<Double>();
        try {
            formLineCrdList(coordinatesX, coordinatesY);
            Point pointX = new Point(coordinatesX.get(0), coordinatesX.get(1), coordinatesX.get(2));
            Point pointY = new Point(coordinatesY.get(0), coordinatesY.get(1), coordinatesY.get(2));
            Line line = new Line(pointX, pointY);
            lineStatus.set(OK_STATUS);
            return line;
        } catch (NumberFormatException | ArithmeticException ex) {
            lineStatus.set(ERROR_STATUS + ": " + ex.getMessage().toLowerCase(Locale.ENGLISH));
            return null;
        }
    }

    public void checkLineAndPlaneIntersection() {
        Plane plane = createPlane();
        Line line = createLine();
        if (plane != null && line != null) {
            try {
                if (getPlaneStatus().equals(OK_STATUS) && getLineStatus().equals(OK_STATUS)) {
                    LineIntersectPlane intersection = new LineIntersectPlane(plane, line);
                    if (intersection.checkIntersection()) {
                        result.set(INTERSECT_STATUS + ": " + intersection.getPointO().toString());
                    } else {
                        result.set(NOT_INTERSECT_STATUS);
                    }
                } else {
                    result.set(ERROR_STATUS);
                }
            } catch (ArithmeticException ex) {
                lineStatus.set(ERROR_STATUS + ": " + ex.getMessage().toLowerCase(Locale.ENGLISH));
            }
        } else {
            result.set(ERROR_STATUS);
        }
    }
}
