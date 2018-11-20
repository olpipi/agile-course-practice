package ru.unn.agile.triangle.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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

    private final BooleanProperty perimeterDisabled = new SimpleBooleanProperty();
    private final BooleanProperty squareDisabled = new SimpleBooleanProperty();

    public ViewModel() {
        initDefaultFields();
    }

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

    public BooleanProperty perimeterDisabledProperty() {
        return perimeterDisabled;
    }

    public final boolean isPerimeterDisabled() {
        return perimeterDisabled.get();
    }

    public BooleanProperty squareDisabledProperty() {
        return squareDisabled;
    }

    public final boolean isSquareDisabled() {
        return squareDisabled.get();
    }

    private void initDefaultFields() {
        aX.set("");
        bX.set("");
        cX.set("");
        aY.set("");
        bY.set("");
        cY.set("");
        result.set("");

        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(aX, aY, bX, bY, cX, cY );
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
        };
        };
        perimeterDisabled.bind(couldCalculate.not());
        squareDisabled.bind(couldCalculate.not());
    }

    public void perimeter() {
        if (perimeterDisabled.get()) {
            return;
        }

        Point pointA = new Point(aX.get(), aY.get());
        Point pointB = new Point(bX.get(), bY.get());
        Point pointC = new Point(cX.get(), cY.get());

        Triangle triangle = new Triangle(pointA, pointB, pointC);

        result.set(String.valueOf(triangle.getPerimeter()));
    }

    public void square() {
        if (squareDisabled.get()) {
            return;
        }

        Point pointA = new Point(aX.get(), aY.get());
        Point pointB = new Point(bX.get(), bY.get());
        Point pointC = new Point(cX.get(), cY.get());

        Triangle triangle = new Triangle(pointA, pointB, pointC);

        result.set(String.valueOf(triangle.getSquare()));
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (aX.get().isEmpty() || aY.get().isEmpty()
                || bX.get().isEmpty() || bY.get().isEmpty()
                || cX.get().isEmpty() || cY.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }
        try {
            if (!aX.get().isEmpty()) {
                Double.parseDouble(aX.get());
            }
            if (!aY.get().isEmpty()) {
                Double.parseDouble(aY.get());
            }
            if (!bX.get().isEmpty()) {
                Double.parseDouble(bX.get());
            }
            if (!bY.get().isEmpty()) {
                Double.parseDouble(bY.get());
            }
            if (!cX.get().isEmpty()) {
                Double.parseDouble(cX.get());
            }
            if (!cY.get().isEmpty()) {
                Double.parseDouble(cY.get());
            }
        } catch (NumberFormatException nfe) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Calculate' or Enter"),
    BAD_FORMAT("Bad format");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
