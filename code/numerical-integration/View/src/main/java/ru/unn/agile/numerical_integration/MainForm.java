package ru.unn.agile.numerical_integration;

import javax.swing.*;

public final class MainForm {
    private JPanel mainPanel;
    private JTextField functionText;
    private JTextField leftBorderText;
    private JTextField rightBorderText;
    private JButton computeIntegralButton;
    private JTextArea outputText;
    private JTextField splitsText;
    private JLabel functionLabel;
    private JLabel splitsLabel;
    private JLabel leftBorderLabel;
    private JLabel rightBorderLabel;
    private JLabel helpText;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private MainForm() {
        suppressUnused(mainPanel);
        suppressUnused(functionText);
        suppressUnused(leftBorderText);
        suppressUnused(rightBorderText);
        suppressUnused(computeIntegralButton);
        suppressUnused(outputText);
        suppressUnused(splitsText);
        suppressUnused(functionLabel);
        suppressUnused(splitsLabel);
        suppressUnused(leftBorderLabel);
        suppressUnused(rightBorderLabel);
        suppressUnused(helpText);
    }

    private static Object suppressUnused(final Object o) {
        return o;
    }
}
