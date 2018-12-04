package ru.unn.agile.shapevolume.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewModelTests {
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
    public void canSetDefaultValues() {
        assertEquals(ViewModel.DEFAULT_VALUE, viewModel.firstArgumentValueProperty().get());
        assertEquals(ViewModel.DEFAULT_VALUE, viewModel.secondArgumentValueProperty().get());
        assertEquals(ViewModel.DEFAULT_VALUE, viewModel.thirdArgumentValueProperty().get());

        assertEquals(Shape.UNKNOWN, viewModel.currentShapeProperty().get());
        assertEquals(ViewModel.DEFAULT_VALUE, viewModel.getFirstArgumentName());
        assertEquals(ViewModel.DEFAULT_VALUE, viewModel.getSecondArgumentName());
        assertEquals(ViewModel.DEFAULT_VALUE, viewModel.getThirdArgumentName());
    }

    @Test
    public void resultWaitingWhenThirdFieldIsEmpty() {
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2");
        assertEquals(ViewModel.WAITING, viewModel.getResult());
    }

    @Test
    public void checkPrismParametersNames() {
        viewModel.currentShapeProperty().set(Shape.REGULAR_POLYGON_PRISM);
        assertEquals(ViewModel.POLYGON_BASE_SIDES_COUNT, viewModel.getFirstArgumentName());
        assertEquals(ViewModel.POLYGON_BASE_SIDES_LENGTH, viewModel.getSecondArgumentName());
        assertEquals(ViewModel.POLYGON_HEIGHT, viewModel.getThirdArgumentName());
    }

    @Test
    public void resultNoWaitingWhenFieldsAreCorrect() {
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertNotEquals(ViewModel.WAITING, viewModel.getResult());
    }

    @Test
    public void checkInvalidSecondArgument() {
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("test");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void checkInvalidFirstArgument() {
        viewModel.firstArgumentValueProperty().set("another test");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void checkInvalidFirstAndThirdArguments() {
        viewModel.firstArgumentValueProperty().set("stub one");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("stub 3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void checkCubeWithTwoThreeFourLengthHasCorrectVolume() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.firstArgumentValueProperty().set("2");
        viewModel.secondArgumentValueProperty().set("3");
        viewModel.thirdArgumentValueProperty().set("4");
        assertEquals("24.000", viewModel.getResult());
    }

    @Test
    public void checkCubeWithThreeFourtFiveLengthHasCorrectVolume() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.firstArgumentValueProperty().set("3");
        viewModel.secondArgumentValueProperty().set("4");
        viewModel.thirdArgumentValueProperty().set("5");
        assertEquals("60.000", viewModel.getResult());
    }

    @Test
    public void canNotCalculateVolumeWithFloatLength() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2.0");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void canNotCalculateCubeVolumeWithNegativeFirstLength() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.firstArgumentValueProperty().set("-1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void canNotCalculateCubeVolumeWithNegativeSecondLength() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("-2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void canCalculateCubeVolumeWithZeroLength() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("0");
        assertEquals("0.000", viewModel.getResult());
    }

    @Test
    public void canCalculateRegularPolygonPrismVolume() {
        viewModel.currentShapeProperty().set(Shape.REGULAR_POLYGON_PRISM);
        viewModel.firstArgumentValueProperty().set("6");
        viewModel.secondArgumentValueProperty().set("1");
        viewModel.thirdArgumentValueProperty().set("2");
        assertEquals("5.196", viewModel.getResult());
    }

    @Test
    public void canNotCalculateRegularPolygonPrismVolumeWithFirstNegativeArgument() {
        viewModel.currentShapeProperty().set(Shape.REGULAR_POLYGON_PRISM);
        viewModel.firstArgumentValueProperty().set("-1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.getResult());
    }

    @Test
    public void checkSwitchShapes() {
        viewModel.currentShapeProperty().set(Shape.REGULAR_POLYGON_PRISM);
        viewModel.currentShapeProperty().set(Shape.CUBE);
    }

    @Test
    public void checkUnknownShapes() {
        viewModel.currentShapeProperty().set(Shape.UNKNOWN);
    }

    @Test
    public void canGetShapesProperty() {
        viewModel.shapesProperty();
    }

    @Test
    public void canGetResultProperty() {
        viewModel.resultProperty();
    }

    @Test
    public void canGetShapes() {
        viewModel.getShapes();
    }

    @Test
    public void canGetFirstArgumentNameProperty() {
        viewModel.firstArgumentNameProperty();
    }

    @Test
    public void canGetSecondArgumentNameProperty() {
        viewModel.secondArgumentNameProperty();
    }

    @Test
    public void canGetThirdArgumentNameProperty() {
        viewModel.thirdArgumentNameProperty();
    }

    @Test
    public void checkShapeToString() {
        assertEquals("Куб", Shape.CUBE.toString());
    }

    @Test
    public void checkSwitchDefault() {
        viewModel.currentShapeProperty().set(Shape.CUBE);
        viewModel.currentShapeProperty().set(Shape.UNKNOWN);
    }
}
