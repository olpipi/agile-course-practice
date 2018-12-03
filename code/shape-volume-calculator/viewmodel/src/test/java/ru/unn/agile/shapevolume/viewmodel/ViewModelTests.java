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

        assertEquals(Shapes.CUBE, viewModel.currentShapeProperty().get());
        assertEquals(ViewModel.CUBE_FIRST_SIDE, viewModel.firstArgumentNameProperty().get());
        assertEquals(ViewModel.CUBE_SECOND_SIDE, viewModel.secondArgumentNameProperty().get());
        assertEquals(ViewModel.CUBE_THIRD_SIDE, viewModel.thirdArgumentNameProperty().get());
    }

    @Test
    public void resultWaitingWhenThirdFieldIsEmpty() {
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2");
        assertEquals(ViewModel.WAITING, viewModel.resultProperty().get());
    }

    @Test
    public void checkCubeParametersNames() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        assertEquals(ViewModel.CUBE_FIRST_SIDE, viewModel.firstArgumentNameProperty().get());
        assertEquals(ViewModel.CUBE_SECOND_SIDE, viewModel.secondArgumentNameProperty().get());
        assertEquals(ViewModel.CUBE_THIRD_SIDE, viewModel.thirdArgumentNameProperty().get());
    }

    @Test
    public void checkPrismParametersNames() {
        viewModel.currentShapeProperty().set(Shapes.REGULAR_POLYGON_PRISM);
        assertEquals(ViewModel.POLYGON_BASE_SIDES_COUNT, viewModel.firstArgumentNameProperty().get());
        assertEquals(ViewModel.POLYGON_BASE_SIDES_LENGTH, viewModel.secondArgumentNameProperty().get());
        assertEquals(ViewModel.POLYGON_HEIGHT, viewModel.thirdArgumentNameProperty().get());
    }

    @Test
    public void resultNoWaitingWhenFieldsAreCorrect() {
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertNotEquals(ViewModel.WAITING, viewModel.resultProperty().get());
    }

    @Test
    public void checkInvalidSecondArgument() {
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("test");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }

    @Test
    public void checkInvalidFirstArgument() {
        viewModel.firstArgumentValueProperty().set("another test");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }

    @Test
    public void checkInvalidFirstAndThirdArguments() {
        viewModel.firstArgumentValueProperty().set("stub one");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("stub 3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }

    @Test
    public void checkCubeWithTwoThreeFourLengthHasCorrectVolume() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        viewModel.firstArgumentValueProperty().set("2");
        viewModel.secondArgumentValueProperty().set("3");
        viewModel.thirdArgumentValueProperty().set("4");
        assertEquals("24,000", viewModel.resultProperty().get());
    }

    @Test
    public void checkCubeWithThreeFourtFiveLengthHasCorrectVolume() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        viewModel.firstArgumentValueProperty().set("3");
        viewModel.secondArgumentValueProperty().set("4");
        viewModel.thirdArgumentValueProperty().set("5");
        assertEquals("60,000", viewModel.resultProperty().get());
    }

    @Test
    public void canNotCalculateVolumeWithFloatLength() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2.0");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }

    @Test
    public void canNotCalculateCubeVolumeWithNegativeFirstLength() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        viewModel.firstArgumentValueProperty().set("-1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }

    @Test
    public void canNotCalculateCubeVolumeWithNegativeSecondLength() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("-2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }

    @Test
    public void canCalculateCubeVolumeWithZeroLength() {
        viewModel.currentShapeProperty().set(Shapes.CUBE);
        viewModel.firstArgumentValueProperty().set("1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("0");
        assertEquals("0,000", viewModel.resultProperty().get());
    }

    @Test
    public void canCalculateRegularPolygonPrismVolume() {
        viewModel.currentShapeProperty().set(Shapes.REGULAR_POLYGON_PRISM);
        viewModel.firstArgumentValueProperty().set("6");
        viewModel.secondArgumentValueProperty().set("1");
        viewModel.thirdArgumentValueProperty().set("2");
        assertEquals("5,196", viewModel.resultProperty().get());
    }

    @Test
    public void canNotCalculateRegularPolygonPrismVolumeWithFirstNegativeArgument() {
        viewModel.currentShapeProperty().set(Shapes.REGULAR_POLYGON_PRISM);
        viewModel.firstArgumentValueProperty().set("-1");
        viewModel.secondArgumentValueProperty().set("2");
        viewModel.thirdArgumentValueProperty().set("3");
        assertEquals(ViewModel.INVALID_ARGUMENTS, viewModel.resultProperty().get());
    }
}
