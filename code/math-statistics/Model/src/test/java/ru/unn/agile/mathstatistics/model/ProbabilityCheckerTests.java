package ru.unn.agile.mathstatistics.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProbabilityCheckerTests {

    @Test
    public void canDetectCorrectProbability() {
        Double probability = (ProbabilityChecker.UPPER_PROBABILITY_BOUND +
                ProbabilityChecker.LOWER_PROBABILITY_BOUND) / 2.0;

        assertTrue(ProbabilityChecker.isProbabilityCorrect(probability));
    }

    @Test
    public void canDetectProbabilityWhichIsHigherThanUpperBound() {
        Double probability = ProbabilityChecker.UPPER_PROBABILITY_BOUND + 1.0;

        assertFalse(ProbabilityChecker.isProbabilityCorrect(probability));
    }

    @Test
    public void canDetectProbabilityWhichIsLessThanLowerBound() {
        Double probability = ProbabilityChecker.LOWER_PROBABILITY_BOUND - 1.0;

        assertFalse(ProbabilityChecker.isProbabilityCorrect(probability));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenPassedNullProbability() {
        Double probability = null;

        ProbabilityChecker.isProbabilityCorrect(probability);
    }
}
