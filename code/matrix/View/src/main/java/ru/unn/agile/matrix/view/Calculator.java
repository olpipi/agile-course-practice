package ru.unn.agile.matrix.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import ru.unn.agile.matrix.viewmodel.Operation;
import ru.unn.agile.matrix.viewmodel.ViewModel;
import ru.unn.agile.matrix.infrastructure.TxtLogger;

public class Calculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField matrixA;
    @FXML
    private TextField matrixB;
    @FXML
    private ComboBox<Operation> operation;
    @FXML
    private Button calculateButton;
    @FXML
    private TextField result;
    @FXML
    private Text status;
    @FXML
    private ListView logView;

    @FXML
    void initialize() {
        viewModel = new ViewModel(new TxtLogger("./MatrixCalc.log"));

        matrixA.textProperty().bindBidirectional(viewModel.matrixAProperty());
        matrixB.textProperty().bindBidirectional(viewModel.matrixBProperty());
        operation.setItems(viewModel.operationsProperty().getValue());
        operation.valueProperty().bindBidirectional(viewModel.operationProperty());
        result.textProperty().bindBidirectional(viewModel.resultProperty());
        status.textProperty().bindBidirectional(viewModel.statusProperty());

        calculateButton.disableProperty().bindBidirectional(
                viewModel.calculateButtonDisabledProperty()
        );

        calculateButton.setOnAction(event -> viewModel.calculate());

        logView.itemsProperty().bindBidirectional(viewModel.logProperty());
    }
}
