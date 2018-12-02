package ru.unn.agile.intersect.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import ru.unn.agile.intersect.viewmodel.ViewModel;

public class LineIntersectPlane {
    @FXML
    private ViewModel viewModel;

    @FXML
    private TextField coordXFirstPlanePoint;
    @FXML
    private TextField coordYFirstPlanePoint;
    @FXML
    private TextField coordZFirstPlanePoint;

    @FXML
    private TextField coordXSecondPlanePoint;
    @FXML
    private TextField coordYSecondPlanePoint;
    @FXML
    private TextField coordZSecondPlanePoint;

    @FXML
    private TextField coordXThirdPlanePoint;
    @FXML
    private TextField coordYThirdPlanePoint;
    @FXML
    private TextField coordZThirdPlanePoint;

    @FXML
    private TextField coordXFirstLinePoint;
    @FXML
    private TextField coordYFirstLinePoint;
    @FXML
    private TextField coordZFirstLinePoint;

    @FXML
    private TextField coordXSecondLinePoint;
    @FXML
    private TextField coordYSecondLinePoint;
    @FXML
    private TextField coordZSecondLinePoint;

    @FXML
    private Button checkIntersectionButton;

    @FXML
    void initialize() {
        coordXFirstPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordXFirstPlanePointProperty());
        coordYFirstPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordYFirstPlanePointProperty());
        coordZFirstPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordZFirstPlanePointProperty());

        coordXSecondPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordXSecondPlanePointProperty());
        coordYSecondPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordYSecondPlanePointProperty());
        coordZSecondPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordZSecondPlanePointProperty());

        coordXThirdPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordXThirdPlanePointProperty());
        coordYThirdPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordYThirdPlanePointProperty());
        coordZThirdPlanePoint.textProperty().bindBidirectional(
                viewModel.getCoordZThirdPlanePointProperty());

        coordXFirstLinePoint.textProperty().bindBidirectional(
                viewModel.getCoordXFirstLinePointProperty());
        coordYFirstLinePoint.textProperty().bindBidirectional(
                viewModel.getCoordYFirstLinePointProperty());
        coordZFirstLinePoint.textProperty().bindBidirectional(
                viewModel.getCoordZFirstLinePointProperty());

        coordXSecondLinePoint.textProperty().bindBidirectional(
                viewModel.getCoordXSecondLinePointProperty());
        coordYSecondLinePoint.textProperty().bindBidirectional(
                viewModel.getCoordYSecondLinePointProperty());
        coordZSecondLinePoint.textProperty().bindBidirectional(
                viewModel.getCoordZSecondLinePointProperty());

        checkIntersectionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.checkLineAndPlaneIntersection();
            }
        });
    }
}
