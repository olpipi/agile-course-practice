package ru.unn.agile.mathstatistics.viewmodel;

import java.util.ArrayList;

public class ViewModel {
    private ArrayList<Number> values;
    private ArrayList<Double> probabilities;

    private String valueText;
    private String probabilityText;
    private Operation operation;
    private String orderText;
    private String resultText;
    private String statusMessageText;

    private boolean isAddToSampleButtonEnabled;
    private boolean isClearButtonEnabled;
    private boolean isCalculateButtonEnabled;

    public ViewModel() {
        values = new ArrayList<Number>();
        probabilities = new ArrayList<Double>();

        valueText = "";
        probabilityText = "";
        operation = Operation.EXPECTED_VALUE;
        orderText = "";
        resultText = "";
        statusMessageText = Status.WAITING;

        isAddToSampleButtonEnabled = true;
        isClearButtonEnabled = false;
        isCalculateButtonEnabled = false;
    }

    public boolean isAddToSampleButtonEnabled() {
        return isAddToSampleButtonEnabled;
    }

    public boolean isClearButtonEnabled() {
        return isClearButtonEnabled;
    }

    public boolean isCalculateButtonEnabled() {
        return isCalculateButtonEnabled;
    }

    public String getValueText() {
        return valueText;
    }

    public String getProbabilityText() {
        return probabilityText;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(final Operation operation) {
        this.operation = operation;
    }

    public String getOrderText() {
        return orderText;
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
        private final String name;

        Operation(final String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public final class Status {
        public static final String WAITING = "Please provide input data";
        public static final String READY = "Press 'Calculate'";
        public static final String BAD_FORMAT = "Bad format";
        public static final String SUCCESS = "Success";

        private Status() { }
    }
}
