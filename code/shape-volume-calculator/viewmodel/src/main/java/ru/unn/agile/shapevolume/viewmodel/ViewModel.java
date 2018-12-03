package ru.unn.agile.shapevolume.viewmodel;

import ru.unn.agile.shapevolume.model.Cuboid;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import ru.unn.agile.shapevolume.model.RegularPolygonPrism;

import java.util.Arrays;
import java.util.List;


enum Shapes {
    CUBE("Куб"),
    REGULAR_POLYGON_PRISM("Правильная призма");

    private final String name;
    Shapes(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}


public class ViewModel {
    private final StringProperty firstArgumentName = new SimpleStringProperty();
    private final StringProperty secondArgumentName = new SimpleStringProperty();
    private final StringProperty thirdArgumentName = new SimpleStringProperty();

    private final StringProperty firstArgumentValue = new SimpleStringProperty();
    private final StringProperty secondArgumentValue = new SimpleStringProperty();
    private final StringProperty thirdArgumentValue = new SimpleStringProperty();

    private final ObjectProperty<Shapes> currentShape = new SimpleObjectProperty<>();
    private final StringProperty result = new SimpleStringProperty();

    public static final String CUBE_FIRST_SIDE = "a";
    public static final String CUBE_SECOND_SIDE = "b";
    public static final String CUBE_THIRD_SIDE = "c";

    public static final String POLYGON_BASE_SIDES_COUNT = "Количество сторон";
    public static final String POLYGON_BASE_SIDES_LENGTH = "Длина стороны";
    public static final String POLYGON_HEIGHT = "Высота призмы";

    public static final String WAITING = "Ожидание ввода данных";
    public static final String INVALID_ARGUMENTS =
            "Некорректные входные данные";
    public static final String DEFAULT_VALUE = "";


    public ViewModel() {
        firstArgumentName.set(CUBE_FIRST_SIDE);
        secondArgumentName.set(CUBE_SECOND_SIDE);
        thirdArgumentName.set(CUBE_THIRD_SIDE);

        currentShape.set(Shapes.CUBE);
        firstArgumentValue.set(DEFAULT_VALUE);
        secondArgumentValue.set(DEFAULT_VALUE);
        thirdArgumentValue.set(DEFAULT_VALUE);

        result.set(WAITING);

        currentShape.addListener((ObservableValue<? extends Shapes> observable,
                                  Shapes oldValue, Shapes newValue) -> {
            if (!oldValue.equals(newValue)) {
                switch (newValue) {
                    case CUBE:
                        firstArgumentName.set(CUBE_FIRST_SIDE);
                        secondArgumentName.set(CUBE_SECOND_SIDE);
                        thirdArgumentName.set(CUBE_THIRD_SIDE);
                        break;
                    case REGULAR_POLYGON_PRISM:
                        firstArgumentName.set(POLYGON_BASE_SIDES_COUNT);
                        secondArgumentName.set(POLYGON_BASE_SIDES_LENGTH);
                        thirdArgumentName.set(POLYGON_HEIGHT);
                        break;
                    default:
                        firstArgumentName.set(DEFAULT_VALUE);
                        secondArgumentName.set(DEFAULT_VALUE);
                        thirdArgumentName.set(DEFAULT_VALUE);
                        result.set(INVALID_ARGUMENTS);
                        break;
                }
            }
        });

        List<StringProperty> arguments =
                Arrays.asList(firstArgumentValue, secondArgumentValue, thirdArgumentValue);
        for (StringProperty argument : arguments) {
            argument.addListener((ObservableValue<? extends String> observable,
                               String oldValue, String newValue) -> {
                if (!oldValue.equals(newValue)) {
                    String firstArgumentString = firstArgumentValue.get();
                    String secondArgumentString = secondArgumentValue.get();
                    String thirdArgumentString = thirdArgumentValue.get();
                    if ("".equals(firstArgumentString) || "".equals(secondArgumentString)
                            || "".equals(thirdArgumentString)) {
                        result.set(WAITING);
                        return;
                    }

                    int first, second, third;
                    try {
                        first = Integer.parseInt(firstArgumentString);
                        second = Integer.parseInt(secondArgumentString);
                        third = Integer.parseInt(thirdArgumentString);
                    } catch (NumberFormatException nfe) {
                        result.set(INVALID_ARGUMENTS);
                        return;
                    }

                    if ((first < 0) || (second < 0) || (third < 0)) {
                        result.set(INVALID_ARGUMENTS);
                        return;
                    }

                    double volume;
                    switch (currentShape.get()) {
                        case CUBE:
                            volume = new Cuboid(first, second, third).getVolume();
                            break;
                        case REGULAR_POLYGON_PRISM:
                            volume = new RegularPolygonPrism(first, second, third).getVolume();
                            break;
                        default:
                            result.set(INVALID_ARGUMENTS);
                            return;
                    }
                    result.set(String.format("%.3f", volume));
                }
            });
        }
    }

    public StringProperty firstArgumentNameProperty() {
        return firstArgumentName;
    }
    public StringProperty secondArgumentNameProperty() {
        return secondArgumentName;
    }
    public StringProperty thirdArgumentNameProperty() {
        return thirdArgumentName;
    }
    public StringProperty firstArgumentValueProperty() {
        return firstArgumentValue;
    }
    public StringProperty secondArgumentValueProperty() {
        return secondArgumentValue;
    }
    public StringProperty thirdArgumentValueProperty() {
        return thirdArgumentValue;
    }
    public ObjectProperty<Shapes> currentShapeProperty() {
        return currentShape;
    }
    public StringProperty resultProperty() {
        return result;
    }
}
