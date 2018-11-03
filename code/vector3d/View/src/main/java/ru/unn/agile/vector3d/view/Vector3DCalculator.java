package ru.unn.agile.vector3d.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.vector3d.model.Vector3D;
import ru.unn.agile.vector3d.viewmodel.ViewModel;

public class Vector3DCalculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtVectorX;
    @FXML
    private TextField txtVectorY;
    @FXML
    private TextField txtVectorZ;
    @FXML
    private TextField txtOtherVectorX;
    @FXML
    private TextField txtOtherVectorY;
    @FXML
    private TextField txtOtherVectorZ;
    @FXML
    private TextField txtMultCoeff;
    @FXML
    private ComboBox<Vector3D.Operation> cbOperation;
    @FXML
    private Button btnCalc;

    @FXML
    void initialize() {

    }
}
