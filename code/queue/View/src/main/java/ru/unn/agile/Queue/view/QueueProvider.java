package ru.unn.agile.Queue.view;

import javax.swing.*;

public class QueueProvider {
    private JPanel panel1;
    private JButton clearQueueButton;
    private JButton addElementButton;
    private JButton removeHeadButton;
    private JTextField textField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("QueueProvider");
        frame.setContentPane(new QueueProvider().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
