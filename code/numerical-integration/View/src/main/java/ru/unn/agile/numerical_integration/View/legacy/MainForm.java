package ru.unn.agile.numerical_integration.View.legacy;

import ru.unn.agile.numerical_integration.ViewModel.legacy.ViewModel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class MainForm {
    private final ViewModel model = new ViewModel();

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


        computeIntegralButton.addActionListener(e -> {
            bind();
            model.compute();
            backBind();
        });

        KeyAdapter messageUpdater = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                bind();
                backBind();
            }
        };
        functionText.addKeyListener(messageUpdater);
        leftBorderText.addKeyListener(messageUpdater);
        rightBorderText.addKeyListener(messageUpdater);
        splitsText.addKeyListener(messageUpdater);
    }

    private void bind() {
        model.setFunction(functionText.getText());
        model.setLeftBorderValue(leftBorderText.getText());
        model.setRightBorderValue(rightBorderText.getText());
        model.setSplitsNumber(splitsText.getText());
    }

    private void backBind() {
        functionText.setText(model.getFunctionText());
        leftBorderText.setText(model.getLeftBorderValue());
        rightBorderText.setText(model.getRightBorderValue());
        splitsText.setText(model.getSplitsNumber());
        computeIntegralButton.setEnabled(model.canComputeFunction());
        outputText.setText(model.getOutputMessage());
    }

    private static Object suppressUnused(final Object o) {
        return o;
    }
}
