package ru.unn.agile.mathstatistics.view;

import javax.swing.*;

public final class MathStatisticsCalculator {
    private JTextField valueText;
    private JTextField probabilityText;
    private JButton addToDistributionButton;
    private JButton clearButton;
    private JComboBox operationComboBox;
    private JButton calculateButton;
    private JPanel mainPanel;
    private JTextField orderText;
    private JTextField resultText;
    private JPanel valueIndicatorLabel;
    private JLabel probabilityIndicatorLabel;
    private JLabel resultLabel;
    private JLabel statusLabel;
    private JLabel statusMessageLabel;
    private JTextArea sampleTextArea;
    private JLabel valueProbabilityPair;
    private JPanel orderLabel;
    private JLabel offsetLabel;
    private JTextField offsetText;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("MathStatisticsCalculator");
        frame.setContentPane(new MathStatisticsCalculator().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
