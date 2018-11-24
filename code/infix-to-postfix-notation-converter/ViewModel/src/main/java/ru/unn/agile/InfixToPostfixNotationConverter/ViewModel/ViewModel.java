package ru.unn.agile.InfixToPostfixNotationConverter.ViewModel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.*;

import ru.unn.agile.InfixToPostfixNotationConverter.Model.InfixToPostfixNotationConverter;

import java.util.Arrays;

public class ViewModel {
    private final StringProperty infixExpression = new SimpleStringProperty();
    private final StringProperty postfixExpression = new SimpleStringProperty();
    private final StringProperty expressionResult = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final BooleanProperty convertButtonDisabled = new SimpleBooleanProperty();
    private final ValueChangeListener valueChangeListener = new ValueChangeListener();

    public ViewModel() {
        infixExpression.set("");
        postfixExpression.set("");
        expressionResult.set("");
        status.set(Status.WAITING.toString());
        convertButtonDisabled.set(true);

        infixExpression.addListener(valueChangeListener);
    }

    public StringProperty infixExpressionProperty() {
        return infixExpression;
    }

    public StringProperty postfixExpressionProperty() {
        return postfixExpression;
    }

    public StringProperty expressionResultProperty() {
        return expressionResult;
    }

    public StringProperty statusProperty() {
        return status;
    }
}

enum Status {
    WAITING("Waiting for input"),
    READY("Press 'Convert & Calculate' button"),
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

