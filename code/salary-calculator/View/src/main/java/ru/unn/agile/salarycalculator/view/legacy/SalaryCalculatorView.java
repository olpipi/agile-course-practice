package ru.unn.agile.salarycalculator.view.legacy;

import ru.unn.agile.salarycalculator.viewmodel.legacy.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class SalaryCalculatorView {
    private JPanel mainPanel;
    private JTextField txtSalary;
    private JTextField txtWorkedHours;
    private JTextField txtCountYear;
    private JTextField txtResult;
    private JButton calculateButton;
    private JLabel lbStatus;
    private JTextField txtCountMonth;
    private ViewModel viewModel;

    private SalaryCalculatorView() {
    }

    private SalaryCalculatorView(final ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                SalaryCalculatorView.this.viewModel.calculateSalary();
                backBind();
            }
        });

        KeyAdapter whenInCountType = new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                bind();
                SalaryCalculatorView.this.viewModel.checkCountFields();
                backBind();
            }
        };

        txtSalary.addKeyListener(whenInCountType);
        txtWorkedHours.addKeyListener(whenInCountType);
        txtCountMonth.addKeyListener(whenInCountType);
        txtCountYear.addKeyListener(whenInCountType);
    }

    public static void main(final String[] args) {
        JFrame frame = new JFrame("SalaryCalculatorView");
        frame.setContentPane(new SalaryCalculatorView(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void bind() {
        viewModel.setSalary(txtSalary.getText());
        viewModel.setWorkedHours(txtWorkedHours.getText());
        viewModel.setCountMonth(txtCountMonth.getText());
        viewModel.setCountYear(txtCountYear.getText());
    }

    private void backBind() {
        calculateButton.setEnabled(viewModel.isCalculateButtonEnable());
        txtResult.setText(viewModel.getResult());
        lbStatus.setText(viewModel.getStatus());
    }
}
