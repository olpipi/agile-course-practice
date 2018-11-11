package ru.unn.agile.ArraySorter.view;

import javax.swing.*;

public final class ArraySorterProvider {
    private JPanel mainPanel;
    private JTextField addElementField;
    private JButton addElementButton;
    private JButton clearArrayButton;
    private JButton sortArrayButton;
    private JLabel sourceArray;
    private JLabel array;
    private JLabel sortedArray;
    private JLabel resultSortedArray;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("ArraySorterProvider");
        frame.setContentPane(new ArraySorterProvider().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
