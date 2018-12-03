package ru.unn.agile.shapevolume.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.shapevolume.viewmodel.Shape;
import ru.unn.agile.shapevolume.viewmodel.ViewModel;

public class VolumeCalculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtFirstArgument;
    @FXML
    private TextField txtSecondArgument;
    @FXML
    private TextField txtThirdArgument;
    @FXML
    private ComboBox<Shape> cbShapes;

    @FXML
    void initialize() {
        // Two-way binding hasn't supported by FXML yet, so place it in code-behind
        txtFirstArgument.textProperty().bindBidirectional(viewModel.firstArgumentValueProperty());
        txtSecondArgument.textProperty().bindBidirectional(viewModel.secondArgumentValueProperty());
        txtThirdArgument.textProperty().bindBidirectional(viewModel.thirdArgumentValueProperty());

        cbShapes.valueProperty().bindBidirectional(viewModel.currentShapeProperty());
    }
}
