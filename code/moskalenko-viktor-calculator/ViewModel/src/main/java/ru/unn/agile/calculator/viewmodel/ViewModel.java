package ru.unn.agile.calculator.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import ru.unn.agile.calculator.model.Calculator;
import ru.unn.agile.calculator.model.NumberConverter;
import ru.unn.agile.calculator.model.NumberSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ViewModel {


    private final ObjectProperty<NumberSystem> outputNumberSystem = new SimpleObjectProperty<>();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty userMessage = new SimpleStringProperty();
    private final StringProperty number1 = new SimpleStringProperty();
    private final StringProperty number2 = new SimpleStringProperty();
    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();
    private final List<NumberSystem> numberSystems =
            FXCollections.observableList(Arrays.stream(NumberSystem.values())
                    .filter(s -> !NumberSystem.UNKNOWN.equals(s))
                    .collect(Collectors.toList()));

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {

        outputNumberSystem.setValue(NumberSystem.BINARY);
        result.set("");
        userMessage.set(UserMessages.WAIT_FOR_INPUT.toString());
        calculationDisabled.set(true);
        number1.set("");
        number2.set("");

        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(number1, number2);
            }

            @Override
            protected boolean computeValue() {
                return checkInput() == UserMessages.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());

        final List<StringProperty> fields = Arrays.asList(number1, number2);

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }

    }

    public String getResult() {
        return result.get();
    }

    public String getUserMessage() {
        return userMessage.get();
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }

    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    public StringProperty number1Property() {
        return number1;
    }

    public StringProperty number2Property() {
        return number2;
    }

    public final List<NumberSystem> getNumberSystems() {
        return numberSystems;
    }

    public void calculate() {
        NumberSystem currentSystem = getOutputNumberSystem();
        String a = number1.get();
        String b = number2.get();

        String composedResult = buildSumResult(currentSystem, a, b)
                + buildMultResult(currentSystem, a, b)
                + buildUnaryMinusResult(currentSystem, a, b);
        result.set(composedResult);
        userMessage.set(UserMessages.SUCCESS.toString());
    }

    public NumberSystem getOutputNumberSystem() {
        return outputNumberSystem.get();
    }

    public ObjectProperty<NumberSystem> outputNumberSystemProperty() {
        return outputNumberSystem;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public StringProperty userMessageProperty() {
        return userMessage;
    }


    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            userMessage.set(checkInput().toString());
        }
    }

    private String buildUnaryMinusResult(final NumberSystem currentSystem,
                                         final String a,
                                         final String b) {
        return "Minus: -a = "
                + Calculator.unaryMinus(a, currentSystem)
                + ", -b = "
                + Calculator.unaryMinus(b, currentSystem)
                + "\n";
    }

    private String buildMultResult(final NumberSystem currentSystem,
                                   final String a,
                                   final String b) {
        return "Mult: a*b = "
                + Calculator.multiply(a, b, currentSystem)
                + "\n";
    }

    private String buildSumResult(final NumberSystem currentSystem,
                                  final String a,
                                  final String b) {
        return "Sum: a+b = "
                + Calculator.add(a, b, currentSystem)
                + "\n";
    }

    private UserMessages checkInput() {
        String a = number1.get();
        String b = number2.get();
        if ("".equals(a) || "".equals(b)) {
            return UserMessages.WAIT_FOR_INPUT;
        }

        Integer parsedA = NumberConverter.tryParse(a);
        Integer parsedB = NumberConverter.tryParse(b);
        if ((parsedA == null) || (parsedB == null)) {
            return UserMessages.INPUT_INVALID;
        }

        return UserMessages.READY;
    }
}
