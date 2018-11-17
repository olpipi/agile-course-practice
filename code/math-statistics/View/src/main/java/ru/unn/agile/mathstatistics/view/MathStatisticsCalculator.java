package ru.unn.agile.mathstatistics.view;

import javax.swing.*;

import ru.unn.agile.mathstatistics.viewmodel.ViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public final class MathStatisticsCalculator {
    private JTextField valueText;
    private JTextField probabilityText;
    private JButton addToDistributionButton;
    private JButton resetButton;
    private JComboBox<ViewModel.Operation> operationComboBox;
    private JButton calculateButton;
    private JPanel mainPanel;
    private JTextField momentOrderText;
    private JTextField resultText;
    private JLabel statusMessageLabel;
    private JTextArea sampleTextArea;
    private JTextField momentOffsetText;

    private ViewModel viewModel;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("MathStatisticsCalculator");
        frame.setContentPane(
                new MathStatisticsCalculator(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private MathStatisticsCalculator() {
    }

    private MathStatisticsCalculator(final ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();

        loadListOfOperations();

        addCalculateButtonListener();
        addAddToDistributionButtonListener();
        addResetButtonListener();
        addOperationComboBoxListener();

        addDistributionUnitKeyAdapter();
        addMomentOrderKeyAdapter();
        addMomentOffsetKeyAdapter();
    }

    private void loadListOfOperations() {
        ViewModel.Operation[] operations = ViewModel.Operation.values();
        operationComboBox.setModel(new JComboBox<>(operations).getModel());
    }

    private void addCalculateButtonListener() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                MathStatisticsCalculator.this.viewModel.calculateProcess();
                backBind();
            }
        });
    }

    private void addAddToDistributionButtonListener() {
        addToDistributionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                MathStatisticsCalculator.this.viewModel.addToDistributionProcess();
                backBind();
            }
        });
    }

    private void addResetButtonListener() {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                MathStatisticsCalculator.this.viewModel.resetProcess();
                backBind();
            }
        });
    }

    private void addOperationComboBoxListener() {
        operationComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                backBind();
            }
        });
    }

    private void addDistributionUnitKeyAdapter() {
        KeyAdapter distributionUnitKeyAdapter = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                MathStatisticsCalculator.this.viewModel.checkDistributionUnit();
                backBind();
            }
        };

        valueText.addKeyListener(distributionUnitKeyAdapter);
        probabilityText.addKeyListener(distributionUnitKeyAdapter);
    }

    private void addMomentOrderKeyAdapter() {
        KeyAdapter momentOrderKeyAdapter = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                MathStatisticsCalculator.this.viewModel.checkMomentOrder();
                backBind();
            }
        };

        momentOrderText.addKeyListener(momentOrderKeyAdapter);
    }

    private void addMomentOffsetKeyAdapter() {
        KeyAdapter momentOffsetKeyAdapter = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                MathStatisticsCalculator.this.viewModel.checkMomentOffset();
                backBind();
            }
        };

        momentOffsetText.addKeyListener(momentOffsetKeyAdapter);
    }

    private void bind() {
        viewModel.setValueText(valueText.getText());
        viewModel.setProbabilityText(probabilityText.getText());
        viewModel.setMomentOrderText(momentOrderText.getText());
        viewModel.setMomentOffsetText(momentOffsetText.getText());

        viewModel.setOperation((ViewModel.Operation) operationComboBox.getSelectedItem());
    }

    private void backBind() {
        calculateButton.setEnabled(viewModel.isCalculateButtonEnabled());

        valueText.setText(viewModel.getValueText());
        probabilityText.setText(viewModel.getProbabilityText());
        momentOrderText.setText(viewModel.getMomentOrderText());
        momentOffsetText.setText(viewModel.getMomentOffsetText());
        operationComboBox.setSelectedItem(viewModel.getOperation());
        statusMessageLabel.setText(viewModel.getStatusMessageText());
        resultText.setText(viewModel.getResultText());

        List<String> distributionUnits = viewModel.getDistributionUnits();
        sampleTextArea.setText(distributionUnits.toString());
    }
}
