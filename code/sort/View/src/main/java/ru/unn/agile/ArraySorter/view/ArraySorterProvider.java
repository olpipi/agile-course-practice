package ru.unn.agile.ArraySorter.view;

import javax.swing.*;

public class ArraySorterProvider {
    private JPanel panel1;
    private JTextField textField1;
    private JButton addElementButton;
    private JButton clearButton;
    private JButton sortArrayButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ArraySorterProvider");
        frame.setContentPane(new ArraySorterProvider().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
