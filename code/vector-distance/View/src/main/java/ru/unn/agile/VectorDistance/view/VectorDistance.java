package ru.unn.agile.VectorDistance.view;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;
import ru.unn.agile.VectorDistance.viewmodel.ViewModel;

public class VectorDistance {
    @FXML
    private ViewModel viewModel;
    @FXML
    private ComboBox<Distance> cbDistances;
    @FXML
    void initialize() {
        cbDistances.valueProperty().bindBidirectional(viewModel.distanceProperty());
    }
}
