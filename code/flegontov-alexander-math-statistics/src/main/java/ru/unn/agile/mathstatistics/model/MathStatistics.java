package ru.unn.agile.mathstatistics.model;

public final class MathStatistics {
    private MathStatistics() {
    }

    static double meanCalculate(final Integer[] data) {
        double mean = 0.0;
        for (int i = 0; i < data.length; ++i) {
            mean += data[i];
        }
        mean /= data.length;
        return mean;
    }
}
