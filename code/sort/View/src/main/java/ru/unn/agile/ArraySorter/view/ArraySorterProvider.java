package ru.unn.agile.ArraySorter.view;

import ru.unn.agile.ArraySorter.viewmodel.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class ArraySorterProvider {

    private ViewModel viewModel;
    private JPanel mainPanel;
    private JTextField addElementField;
    private JButton addElementButton;
    private JButton clearArrayButton;
    private JButton sortArrayButton;
    private JTextArea outputSortedArrayArea;
    private JLabel outputStatusLabel;
    private JLabel outputSourceArray;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("ArraySorterProvider");
        frame.setContentPane(new ArraySorterProvider(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private ArraySorterProvider(final ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();

        addElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                bind();
                ArraySorterProvider.this.viewModel.add();
                backBind();
            }
        });

        sortArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                bind();
                ArraySorterProvider.this.viewModel.sort();
                backBind();
            }
        });

        clearArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                bind();
                ArraySorterProvider.this.viewModel.clear();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                bind();
                ArraySorterProvider.this.viewModel.processingAddField(e.getKeyCode());
                backBind();
            }
        };

        addElementField.addKeyListener(keyListener);
    }

    private void bind() {
        viewModel.setElemArray(addElementField.getText());
    }

    private void backBind() {
        addElementButton.setEnabled(viewModel.isAddButtonEnabled());
        sortArrayButton.setEnabled(viewModel.isSortButtonEnabled());
        clearArrayButton.setEnabled(viewModel.isClearButtonEnabled());

        outputSourceArray.setText(viewModel.getOutputSourceArray());
        outputSortedArrayArea.setText(viewModel.getOutputArray());
        outputStatusLabel.setText(viewModel.getCurrentState());
    }
}
