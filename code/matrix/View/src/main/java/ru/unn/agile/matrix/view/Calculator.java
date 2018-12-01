package ru.unn.agile.matrix.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
//import ru.unn.agile.matrix.viewmodel.ViewModel;

public class Calculator {
    //@FXML
    //private ViewModel viewModel;
    @FXML
    private TextField matrixA;
    @FXML
    private TextField matrixB;
    @FXML
    private ComboBox<Object> operation;
    @FXML
    private Button calculateButton;
    @FXML
    private TextField result;
    @FXML
    private Text status;

    @FXML
    void initialize() {
        //empty for now
    }
}
