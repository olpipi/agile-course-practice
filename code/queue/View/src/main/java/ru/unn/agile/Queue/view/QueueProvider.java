package ru.unn.agile.Queue.view;

import ru.unn.agile.queue.viewmodel.ViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class QueueProvider {
    private ViewModel viewModel;

    private JPanel mainPanel;
    private JButton addElementButton;
    private JButton removeHeadButton;
    private JButton clearQueueButton;

    private JLabel addNewElemLabel;
    private JTextField addNewElemField;

    private JLabel queueLabel;
    private JScrollPane outputQueueScrollPane;
    private JTextArea outputQueueTextArea;

    private JLabel stateLabel;
    private JLabel outputStateLabel;


    private QueueProvider(ViewModel viewModel){
        this.viewModel = viewModel;
        backBind();

        addElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bind();
                QueueProvider.this.viewModel.Add();
                backBind();
            }
        });

        removeHeadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bind();
                QueueProvider.this.viewModel.Remove();
                backBind();
            }
        });

        clearQueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bind();
                QueueProvider.this.viewModel.Clear();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                bind();
                QueueProvider.this.viewModel.processingAddField(e.getKeyCode());
                backBind();
            }
        };

        addNewElemField.addKeyListener(keyListener);
    }

    public static void main(final String[] args) {
        JFrame frame = new JFrame("QueueProvider");
        frame.setContentPane(new QueueProvider(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void bind() {
        viewModel.setNewElem(addNewElemField.getText());
    }

    private void backBind() {
        addElementButton.setEnabled(viewModel.isAddButtonEnabled());
        removeHeadButton.setEnabled(viewModel.isRemoveButtonEnabled());
        clearQueueButton.setEnabled(viewModel.isClearButtonEnabled());

        outputQueueTextArea.setText(viewModel.getOutputQueue());
        outputStateLabel.setText(viewModel.getCurrentState());
    }

}
