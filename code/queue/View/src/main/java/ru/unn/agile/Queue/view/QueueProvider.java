package ru.unn.agile.Queue.view;

import javax.swing.*;

public final class QueueProvider {
    private JPanel mainPanel;
    private JButton clearQueueButton;
    private JButton addElementButton;
    private JButton removeHeadButton;
    private JTextField addNewElemField;
    private JLabel queueLabel;
    private JLabel addNewElemLabel;
    private JScrollPane outputQueueScrollPane;
    private JTextArea outputQueueTextArea;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("QueueProvider");
        frame.setContentPane(new QueueProvider().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
