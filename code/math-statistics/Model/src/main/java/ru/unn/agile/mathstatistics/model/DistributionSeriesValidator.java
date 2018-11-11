package ru.unn.agile.mathstatistics.model;

public final class DistributionSeriesValidator {
    public static final Double EPSILON = 1e-3;

    public static void validate(final Number[] values, final Double[] probabilities) {
        validateValues(values);
        validateProbabilities(probabilities);

        if (values.length != probabilities.length) {
            throw new IllegalArgumentException("Values and probabilities sizes aren't equal!");
        }
    }

    private DistributionSeriesValidator() {
    }

    private static void validateValues(final Number[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Data array should be initialized!");
        }

        if (values.length < 1) {
            throw new IllegalArgumentException("Data array length should be positive!");
        }

        for (int i = 0; i < values.length; ++i) {
            if (values[i] == null) {
                throw new IllegalArgumentException("Null element shouldn't be in array!");
            }
        }
    }

    private static void validateProbabilities(final Double[] probabilities) {
        if (probabilities == null) {
            throw new IllegalArgumentException("Probability array should be initialized!");
        }

        if (probabilities.length < 1) {
            throw new IllegalArgumentException("Probability array length should be positive!");
        }

        Double sum = 0.0;
        for (int i = 0; i < probabilities.length; ++i) {
            ProbabilityValidator.validate(probabilities[i]);
            sum += probabilities[i];
        }

        if (Math.abs(1.0 - sum) > EPSILON) {
            throw new IllegalArgumentException("Normalization condition is not satisfied!");
        }
    }
}
