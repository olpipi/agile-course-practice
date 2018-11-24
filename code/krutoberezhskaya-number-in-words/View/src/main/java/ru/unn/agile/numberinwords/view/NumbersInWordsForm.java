package ru.unn.agile.numberinwords.view;

import ru.unn.agile.numberinwords.viewmodel.NumbersInWordsViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class NumbersInWordsForm {
    private NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();
    private JPanel mainPanel;
    private JButton convertButton;
    private JTextField number;
    private JTextField numberInWords;
    private JLabel errorStatus;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("NumbersInWordsForm");
        frame.setContentPane(new NumbersInWordsForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    NumbersInWordsForm() {
        bind();
        convertButton.addActionListener(e -> {
            backBind();
            viewModel.convert();
            bind();
        });

        number.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent e) {
                backBind();
                bind();
            }

            @Override
            public void removeUpdate(final DocumentEvent e) {
                backBind();
                bind();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
               backBind();
               bind();
            }
        });

    }

    private void backBind() {
        viewModel.setNumber(number.getText());
        numberInWords.setText(viewModel.deleteNumberInWords());
    }

    private void bind() {
        convertButton.setEnabled(viewModel.isConvertButtonEnabled());
        numberInWords.setText(viewModel.getNumberInWords());
        errorStatus.setText(viewModel.getErrorMessage());
    }
}
