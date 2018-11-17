package ru.unn.agile.mathstatistics.viewmodel;

import ru.unn.agile.mathstatistics.model.*;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private List<Number> values;
    private List<Double> probabilities;
    private List<String> distributionUnits;

    private String valueText;
    private String probabilityText;
    private Operation operation;
    private String momentOrderText;
    private String momentOffsetText;
    private String resultText;
    private String statusMessageText;

    private boolean isOrderTextEnabled;
    private boolean isOffsetTextEnabled;

    private boolean isCalculateButtonEnabled;

    public ViewModel() {
        values = new ArrayList<Number>();
        probabilities = new ArrayList<Double>();
        distributionUnits = new ArrayList<String>();

        reset();
    }

    public boolean checkDistributionUnit() {
        if (!isDistributionUnitCorrect()) {
            statusMessageText = Status.BAD_DISTRIBUTION_UNIT_FORMAT;

            return false;
        }

        statusMessageText = Status.ADD_TO_DISTRIBUTION_READY;
        return true;
    }

    public boolean checkMomentOrder() {
        if (!isMomentOrderCorrect()) {
            statusMessageText = Status.BAD_MOMENT_ORDER_FORMAT;

            return false;
        }

        int order = Integer.parseInt(momentOrderText);
        try {
            MomentOrderValidator.validate(order);
        } catch (IllegalArgumentException e) {
            statusMessageText = Status.BAD_MOMENT_ORDER_VALUE;

            return false;
        }

        return  true;
    }

    public boolean checkMomentOffset() {
        if (!isMomentOffsetCorrect()) {
            statusMessageText = Status.BAD_MOMENT_OFFSET_FORMAT;

            return false;
        }

        return  true;
    }

    public void addToDistributionProcess() {
        if (!checkDistributionUnit()) {
            return;
        }

        Double value = Double.parseDouble(valueText);
        Double probability = Double.parseDouble(probabilityText);

        processDistributionUnit(value, probability);
    }

    public void calculateProcess() {
        Number[] nativeValuesArray = new Number[values.size()];
        values.toArray(nativeValuesArray);
        Double[] nativeProbabilitiesArray = new Double[probabilities.size()];
        probabilities.toArray(nativeProbabilitiesArray);

        if (operation == Operation.EXPECTED_VALUE) {
            calculateExpectedValue(nativeValuesArray,
                    nativeProbabilitiesArray);
        } else if (operation == Operation.DISPERSION) {
            calculateDispersion(nativeValuesArray,
                    nativeProbabilitiesArray);
        } else if (operation == Operation.INITIAL_MOMENT) {
            if (!checkMomentOrder()) {
                return;
            }

            int order = Integer.parseInt(momentOrderText);

            calculateInitialMoment(nativeValuesArray,
                    nativeProbabilitiesArray, order);
        } else if (operation == Operation.CENTRAL_MOMENT) {
            if (!checkMomentOrder()) {
                return;
            }
            if (!checkMomentOffset()) {
                return;
            }

            int order = Integer.parseInt(momentOrderText);
            Number offset = Double.parseDouble(momentOffsetText);

            calculateCentralMoment(nativeValuesArray,
                    nativeProbabilitiesArray, order, offset);
        }
    }

    public void resetProcess() {
        reset();
    }

    public List<String> getDistributionUnits() {
        return distributionUnits;
    }

    public boolean isOrderTextEnabled() {
        return isOrderTextEnabled;
    }

    public boolean isOffsetTextEnabled() {
        return isOffsetTextEnabled;
    }

    public boolean isCalculateButtonEnabled() {
        return isCalculateButtonEnabled;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(final String valueText) {
        this.valueText = valueText;
    }

    public String getProbabilityText() {
        return probabilityText;
    }

    public void setProbabilityText(final String probabilityText) {
        this.probabilityText = probabilityText;
    }

    public String getMomentOrderText() {
        return momentOrderText;
    }

    public void setMomentOrderText(final String momentOrderText) {
        this.momentOrderText = momentOrderText;
    }

    public String getMomentOffsetText() {
        return momentOffsetText;
    }

    public void setMomentOffsetText(final String momentOffsetText) {
        this.momentOffsetText = momentOffsetText;
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
            isOffsetTextEnabled = false;
        }
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
        private String operationName;

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
        public static final String BAD_DISTRIBUTION_UNIT_FORMAT = "Bad distribution unit format";
        public static final String BAD_PROBABILITY_VALUE =
                "Bad probability value. Should be 0 <= p <= 1";
        public static final String INCORRECT_PROBABILITIES_SUM =
                "Bad probabilities sum. Should be equal to 1";
        public static final String ADD_TO_DISTRIBUTION_SUCCESS =
                "Add to distribution successfully";
        public static final String BAD_MOMENT_ORDER_FORMAT = "Bad moment order format";
        public static final String BAD_MOMENT_ORDER_VALUE =
                "Moment order should be positive integer";
        public static final String BAD_MOMENT_OFFSET_FORMAT = "Bad moment offset format";
        public static final String CALCULATE_READY = "Press 'Calculate'";
        public static final String SUCCESS = "Success";

        private Status() {
        }
    }

    private void processDistributionUnit(final Double value,
                                         final Double probability) {
        try {
            ProbabilityValidator.validate(probability);
        } catch (IllegalArgumentException e) {
            statusMessageText = Status.BAD_PROBABILITY_VALUE;

            return;
        }

        values.add(value);
        probabilities.add(probability);

        Double[] nativeProbabilitiesArray = new Double[probabilities.size()];
        NormalizationConditionChecker.Status status = NormalizationConditionChecker.check(
                        probabilities.toArray(nativeProbabilitiesArray));

        if (status == NormalizationConditionChecker.Status.CONDITION_IS_MET) {
            statusMessageText = Status.CALCULATE_READY;
            applyDistributionUnit(value, probability);
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

    private void applyDistributionUnit(final Double value, final Double probability) {
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

    private boolean isMomentOrderCorrect() {
        try {
            if (momentOrderText.isEmpty()) {
                return false;
            }

            Integer.parseInt(momentOrderText);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean isMomentOffsetCorrect() {
        try {
            if (momentOffsetText.isEmpty()) {
                return false;
            }

            Double.parseDouble(momentOffsetText);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void calculateExpectedValue(final Number[] nativeValuesArray,
                                        final Double[] nativeProbabilitiesArray) {
        Double expectedValue = MathStatistics.calculateExpectedValue(nativeValuesArray,
                        nativeProbabilitiesArray);

        resultText = expectedValue.toString();
        statusMessageText = Status.SUCCESS;
    }

    private void calculateDispersion(final Number[] nativeValuesArray,
                                     final Double[] nativeProbabilitiesArray) {
        Double dispersion = MathStatistics.calculateDispersion(nativeValuesArray,
                nativeProbabilitiesArray);

        resultText = dispersion.toString();
        statusMessageText = Status.SUCCESS;
    }

    private void calculateInitialMoment(final Number[] nativeValuesArray,
                                        final Double[] nativeProbabilitiesArray,
                                        final int order) {
        Double initialMoment = MathStatistics.calculateInitialMoment(nativeValuesArray,
                nativeProbabilitiesArray, order);

        resultText = initialMoment.toString();
        statusMessageText = Status.SUCCESS;
    }

    private void calculateCentralMoment(final Number[] nativeValuesArray,
                                        final Double[] nativeProbabilitiesArray,
                                        final int order,
                                        final Number offset) {
        Double centralMoment = MathStatistics.calculateCentralMoment(nativeValuesArray,
                nativeProbabilitiesArray, order, offset);

        resultText = centralMoment.toString();
        statusMessageText = Status.SUCCESS;
    }

    private boolean isMomentOperation(final Operation operation) {
        return (operation == Operation.INITIAL_MOMENT)
                || (operation == Operation.CENTRAL_MOMENT);
    }

    private void reset() {
        values.clear();
        probabilities.clear();
        distributionUnits.clear();

        valueText = "";
        probabilityText = "";
        operation = Operation.EXPECTED_VALUE;
        momentOrderText = "";
        resultText = "";
        momentOffsetText = "";
        statusMessageText = Status.WAITING;

        isOrderTextEnabled = false;
        isOffsetTextEnabled = false;

        isCalculateButtonEnabled = false;
    }
}
