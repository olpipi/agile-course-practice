package ru.unn.agile.stringcalculator.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.stringcalculator.viewmodel.Operation;
import ru.unn.agile.stringcalculator.viewmodel.ViewModel;

public class StringCalculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtInput;
    @FXML
    private ComboBox<Operation> cbOperation;

    @FXML
    void initialize() {
        txtInput.textProperty().bindBidirectional(viewModel.inputDataProperty());
        cbOperation.valueProperty().bindBidirectional(viewModel.operationProperty());
    }
}
