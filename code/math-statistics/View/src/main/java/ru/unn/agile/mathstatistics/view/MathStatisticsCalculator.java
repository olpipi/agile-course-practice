package ru.unn.agile.mathstatistics.view;

import javax.swing.*;

public class MathStatisticsCalculator {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTable table1;
    private JButton clearButton;
    private JComboBox comboBox1;
    private JButton calculateButton;
    private JPanel mainPanel;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MathStatisticsCalculator");
        frame.setContentPane(new MathStatisticsCalculator().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
