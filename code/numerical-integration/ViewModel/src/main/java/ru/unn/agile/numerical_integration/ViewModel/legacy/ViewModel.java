package ru.unn.agile.numerical_integration.ViewModel.legacy;

public class ViewModel {
    private String function;
    private double leftBorder;
    private double rightBorder;
    private int splitsCount;
    private String outputMessage;


    public ViewModel() {
        function = "";
        leftBorder = 0;
        rightBorder = 0;
        splitsCount = 0;
        outputMessage = "";
    }

    public String getFunction() {
        return function;
    }

    public String getLeftBorderValue() {
        return Double.toString(leftBorder);
    }

    public String getRightBorderValue() {
        return Double.toString(rightBorder);
    }

    public String getSplitsCount() {
        return Integer.toString(splitsCount);
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
