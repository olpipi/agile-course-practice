package ru.unn.agile.mathstatistics.viewmodel;

import ru.unn.agile.mathstatistics.model.*;

import java.util.ArrayList;

public class ViewModel {
    private ArrayList<Number> values;
    private ArrayList<Double> probabilities;
    private ArrayList<String> distributionUnits;

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
        distributionUnits = new ArrayList<String>();

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

    public boolean checkDistributionUnit() {
        if (!isDistributionUnitCorrect()) {
            statusMessageText = Status.BAD_DISTRIBUTION_UNIT_FORMAT;
            isAddToDistributionButtonEnabled = false;

            return false;
        }

        isAddToDistributionButtonEnabled = true;
        statusMessageText = Status.ADD_TO_DISTRIBUTION_READY;
        return true;
    }

    public void addToDistributionProcess() {
        if (!checkDistributionUnit())
            return;

        Double value = Double.parseDouble(valueText);
        Double probability = Double.parseDouble(probabilityText);

        processDistributionUnit(value, probability);
    }

    public ArrayList<String> getDistributionUnits() {
        return distributionUnits;
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
        public static final String ADD_TO_DISTRIBUTION_SUCCESS = "Add to distribution successfully";
        public static final String BAD_PROBABILITY_VALUE = "Bad probability value. Should be 0 <= p <= 1";
        public static final String INCORRECT_PROBABILITIES_SUM = "Bad probabilities sum. Should be equal to 1";
        public static final String CALCULATE_READY = "Press 'Calculate'";
        public static final String BAD_DISTRIBUTION_UNIT_FORMAT = "Bad distribution unit format";
        public static final String SUCCESS = "Success";

        private Status() {
        }
    }

    private void processDistributionUnit(Double value, Double probability) {
        try {
            ProbabilityValidator.validate(probability);
        } catch (IllegalArgumentException e) {
            statusMessageText = Status.BAD_PROBABILITY_VALUE;

            return;
        }

        values.add(value);
        probabilities.add(probability);

        Double[] nativeProbabilitiesArray = new Double[probabilities.size()];
        NormalizationConditionChecker.Status status =
                NormalizationConditionChecker.check(probabilities.toArray(nativeProbabilitiesArray));

        if (status == NormalizationConditionChecker.Status.CONDITION_IS_MET) {
            statusMessageText = Status.CALCULATE_READY;
            isAddToDistributionButtonEnabled = false;
            isCalculateButtonEnabled = true;

            return;
        }
        if (status == NormalizationConditionChecker.Status.BETWEEN_ZERO_AND_ONE) {
            statusMessageText = Status.ADD_TO_DISTRIBUTION_SUCCESS;
            applyDistributionUnit(value, probability);

            return;
        }

        statusMessageText = Status.INCORRECT_PROBABILITIES_SUM;
        values.remove(values.size() - 1);
        probabilities.remove(probabilities.size() - 1);
    }

    private void applyDistributionUnit(Double value, Double probability) {
        String distributionUnit =
                "(" + value.toString() + ", " + probability.toString() + ")";

        distributionUnits.add(distributionUnit);
    }

    private boolean isDistributionUnitCorrect() {
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
