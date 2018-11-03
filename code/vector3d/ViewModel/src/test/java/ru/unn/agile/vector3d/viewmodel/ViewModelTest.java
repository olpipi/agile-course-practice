package ru.unn.agile.vector3d.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.vector3d.model.Vector3D;

import static org.junit.Assert.*;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetInitialVectorValues() {
        // Arrange
        String emptyString = "";

        // Act
        StringProperty initialX = viewModel.vectorXProperty();
        StringProperty initialY = viewModel.vectorYProperty();
        StringProperty initialZ = viewModel.vectorZProperty();

        // Assert
        assertEquals(emptyString, initialX.get());
        assertEquals(emptyString, initialY.get());
        assertEquals(emptyString, initialZ.get());
    }

    @Test
    public void canSetInitialOtherVectorValues() {
        // Arrange
        String emptyString = "";

        // Act
        StringProperty initialOtherX = viewModel.otherVectorXProperty();
        StringProperty initialOtherY = viewModel.otherVectorYProperty();
        StringProperty initialOtherZ = viewModel.otherVectorZProperty();

        // Assert
        assertEquals(emptyString, initialOtherX.get());
        assertEquals(emptyString, initialOtherY.get());
        assertEquals(emptyString, initialOtherZ.get());
    }

    @Test
    public void canSetDefaultMultiplicationCoeffAndResult() {
        // Arrange
        String emptyString = "";

        // Act
        StringProperty defaultMultCoeff = viewModel.multiplicationCoeffProperty();
        StringProperty defaultResult = viewModel.resultProperty();

        // Assert
        assertEquals(emptyString, defaultMultCoeff.get());
        assertEquals(emptyString, defaultResult.get());
    }


    @Test
    public void canSetDefaultOperationAndStatus() {
        // Arrange & Act
        ObjectProperty<Vector3D.Operation> defaultOperation = viewModel.operationProperty();
        StringProperty defaultStatus = viewModel.statusProperty();

        // Assert
        assertEquals(Vector3D.Operation.ADD, defaultOperation.get());
        assertEquals(ViewModel.Status.WAITING.toString(), defaultStatus.get());
    }

    @Test
    public void statusIsWaitingWhenCalculateWithEmptyFields() {
        // Arrange & Act
        viewModel.calculate();

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.WAITING.toString(), expectedStatus.get());
    }

    @Test
    public void buttonIsDisabledWhenCalculateWithEmptyFields() {
        // Arrange & Act
        viewModel.calculate();

        // Assert
        BooleanProperty expectedButtonState = viewModel.calculationDisabledProperty();
        assertTrue(expectedButtonState.get());
    }

    @Test
    public void statusIsReadyWhenCalculateWithEmptyFields() {
        // Arrange & Act
        setInputData();

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.READY.toString(), expectedStatus.get());
    }

    @Test
    public void canReportBadFormat() {
        // Arrange & Act
        viewModel.vectorXProperty().set("1");
        viewModel.vectorYProperty().set("aa");

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.BAD_FORMAT.toString(), expectedStatus.get());
    }

    @Test
    public void calculateButtonIsDisabledWhenFormatIsBad() {
        // Arrange & Act
        setInputData();
        viewModel.vectorXProperty().set("trash");

        // Assert
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsEnabledWithCorrectInput() {
        // Arrange & Act
        setInputData();

        // Assert
        assertFalse(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWithIncompleteInput() {
        // Arrange & Act
        viewModel.vectorXProperty().set("1");

        // Assert
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void canSetAddOperation() {
        // Arrange & Act
        viewModel.operationProperty().set(Vector3D.Operation.ADD);

        // Assert
        assertEquals(Vector3D.Operation.ADD, viewModel.operationProperty().get());
    }

    @Test
    public void addIsDefaultOperation() {
        // Arrange & Act & Assert
        assertEquals(Vector3D.Operation.ADD, viewModel.operationProperty().get());
    }

    private void setInputData() {
        viewModel.vectorXProperty().set("1");
        viewModel.vectorYProperty().set("2");
        viewModel.vectorZProperty().set("3");

        viewModel.otherVectorXProperty().set("1");
        viewModel.otherVectorYProperty().set("2");
        viewModel.otherVectorZProperty().set("3");
    }
}
