package ru.unn.agile.mathstatistics.model;

public class MathStatistics {
    static double MeanCalculate(Integer[] data)
    {
        double mean = 0;
        for(int i=0; i < data.length; i++)
        {
            mean += data[i];
        }
        mean /= data.length;
        return mean;
    }
}
