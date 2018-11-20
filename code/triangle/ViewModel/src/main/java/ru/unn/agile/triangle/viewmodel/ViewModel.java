package ru.unn.agile.triangle.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.Triangle;
import ru.unn.agile.primitives.Point;

public class ViewModel {
    private StringProperty aX = new SimpleStringProperty();
    private StringProperty bX = new SimpleStringProperty();
    private StringProperty cX = new SimpleStringProperty();
    private StringProperty aY = new SimpleStringProperty();
    private StringProperty bY = new SimpleStringProperty();
    private StringProperty cY = new SimpleStringProperty();
    private StringProperty result = new SimpleStringProperty();

    public String getAx() {
        return aX.get();
    }

    public StringProperty aXProperty() {
        return aX;
    }

    public String getBx() {
        return bX.get();
    }

    public StringProperty bXProperty() {
        return bX;
    }

    public String getCx() {
        return cX.get();
    }

    public StringProperty cXProperty() {
        return cX;
    }

    public String getAy() {
        return aY.get();
    }

    public StringProperty aYProperty() {
        return aY;
    }

    public String getBy() {
        return bY.get();
    }

    public StringProperty bYProperty() {
        return bY;
    }

    public String getCy() {
        return cY.get();
    }

    public StringProperty cYProperty() {
        return cY;
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public ViewModel() {
        initDefaultFields();
    }

    private void initDefaultFields() {
        aX.set("");
        bX.set("");
        cX.set("");
        aY.set("");
        bY.set("");
        cY.set("");
        result.set("");
    }

    public void perimeter() {
        Point pointA = new Point(aX.get(), aY.get());
        Point pointB = new Point(bX.get(), bY.get());
        Point pointC = new Point(cX.get(), cY.get());

        Triangle triangle = new Triangle(pointA, pointB, pointC);

        result.set(String.valueOf(triangle.getPerimeter()));
    }

    public void square() {
        Point pointA = new Point(aX.get(), aY.get());
        Point pointB = new Point(bX.get(), bY.get());
        Point pointC = new Point(cX.get(), cY.get());

        Triangle triangle = new Triangle(pointA, pointB, pointC);

        result.set(String.valueOf(triangle.getSquare()));
    }
}
