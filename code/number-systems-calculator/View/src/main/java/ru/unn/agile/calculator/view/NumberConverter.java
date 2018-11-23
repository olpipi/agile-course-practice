package ru.unn.agile.calculator.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.calculator.model.NumberSystem;
import ru.unn.agile.calculator.viewmodel.ViewModel;


public class NumberConverter {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private ComboBox<NumberSystem> outputSystem;
    @FXML
    private Button btnCalc;

    @FXML
    void initialize() {
        txtNumber1.textProperty().bindBidirectional(viewModel.number1Property());
        txtNumber2.textProperty().bindBidirectional(viewModel.number2Property());
        outputSystem.valueProperty().bindBidirectional(viewModel.outputNumberSystemProperty());


        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.calculate();
            }
        });
    }
}
