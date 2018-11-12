package ru.unn.agile.mathstatistics.viewmodel;

import ru.unn.agile.mathstatistics.model.*;

import java.util.ArrayList;

public class ViewModel {
    private ArrayList<Number> values;
    private ArrayList<Double> probabilities;

    private String valueText;
    private String probabilityText;
    private Operation operation;
    private String orderText;
    private String offsetText;
    private String resultText;
    private String statusMessageText;

    private boolean isOrderTextEnabled;
    private boolean isOffsetTextEnabled;

    private boolean isAddToDistributionButtonEnabled;
    private boolean isCalculateButtonEnabled;

    public ViewModel() {
        values = new ArrayList<Number>();
        probabilities = new ArrayList<Double>();

        valueText = "";
        probabilityText = "";
        operation = Operation.EXPECTED_VALUE;
        orderText = "";
        resultText = "";
        offsetText = "";
        statusMessageText = Status.WAITING;

        isOrderTextEnabled = false;
        isOffsetTextEnabled = false;

        isAddToDistributionButtonEnabled = true;
        isCalculateButtonEnabled = false;
    }

    public void validateInputData() {
        if (!isInputDataFormatCorrect()) {
            statusMessageText = Status.BAD_INPUT_FORMAT;
            isAddToDistributionButtonEnabled = false;
        }
    }

    public boolean isOrderTextEnabled() {
        return isOrderTextEnabled;
    }

    public boolean isOffsetTextEnabled() {
        return isOffsetTextEnabled;
    }

    public boolean isAddToDistributionButtonEnabled() {
        return isAddToDistributionButtonEnabled;
    }

    public boolean isCalculateButtonEnabled() {
        return isCalculateButtonEnabled;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public String getProbabilityText() {
        return probabilityText;
    }

    public void setProbabilityText(String probabilityText) {
        this.probabilityText = probabilityText;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(final Operation operation) {
        this.operation = operation;

        if (isMomentOperation(operation)) {
            isOrderTextEnabled = true;
            if (operation == Operation.CENTRAL_MOMENT) {
                isOffsetTextEnabled = true;
            } else {
                isOffsetTextEnabled = false;
            }
        } else {
            isOrderTextEnabled = false;
        }
    }

    public String getOrderText() {
        return orderText;
    }

    public String getOffsetText() {
        return offsetText;
    }

    public String getResultText() {
        return resultText;
    }

    public String getStatusMessageText() {
        return statusMessageText;
    }

    public enum Operation {
        EXPECTED_VALUE("Expected value"),
        DISPERSION("Dispersion"),
        INITIAL_MOMENT("Initial moment"),
        CENTRAL_MOMENT("Central moment");
        private final String operationName;

        Operation(final String name) {
            this.operationName = name;
        }

        public String toString() {
            return operationName;
        }
    }

    public final class Status {
        public static final String WAITING = "Please provide input data";
        public static final String ADD_TO_DISTRIBUTION_READY = "Press 'Add to distribution'";
        public static final String CALCULATE_READY = "Press 'Calculate'";
        public static final String BAD_INPUT_FORMAT = "Bad input format";
        public static final String SUCCESS = "Success";

        private Status() { }
    }

    private boolean isInputDataFormatCorrect() {
        try {
            if (valueText.isEmpty() || probabilityText.isEmpty()) {
                return false;
            }

            Double.parseDouble(valueText);
            Double.parseDouble(probabilityText);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean isMomentOperation(Operation operation) {
        return (operation == Operation.INITIAL_MOMENT) ||
                (operation == Operation.CENTRAL_MOMENT);
    }
}
