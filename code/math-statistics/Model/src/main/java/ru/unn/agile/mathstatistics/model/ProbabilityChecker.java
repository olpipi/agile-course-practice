package ru.unn.agile.mathstatistics.model;

public final class ProbabilityChecker {
    public static Double LOWER_PROBABILITY_BOUND = 0.0;
    public static Double UPPER_PROBABILITY_BOUND = 1.0;

    public static boolean isProbabilityCorrect(Double probability) {
        if (probability == null) {
           throw new IllegalArgumentException("Probability should be initialized!");
        }
        return LOWER_PROBABILITY_BOUND <= probability &&
                probability <= UPPER_PROBABILITY_BOUND;
    }

    private ProbabilityChecker() {
    }
}
