package ru.unn.agile.fraction.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.unn.agile.fraction.model.Fraction.Operation;

import static org.junit.Assert.*;

public class ViewModelTest {
    private ViewModel viewModel;

    private void setInputData() {
        viewModel.firstNumeratorProperty().set("1");
        viewModel.firstDenominatorProperty().set("2");
        viewModel.secondNumeratorProperty().set("3");
        viewModel.secondDenominatorProperty().set("4");
    }

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void initViewModelWithDefaultValues() {
        assertEquals("", viewModel.firstNumeratorProperty().get());
        assertEquals("", viewModel.firstDenominatorProperty().get());
        assertEquals("", viewModel.secondNumeratorProperty().get());
        assertEquals("", viewModel.secondDenominatorProperty().get());
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
        assertEquals("", viewModel.resultNumeratorProperty().get());
        assertEquals("", viewModel.resultDenominatorProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void viewModelPropertiesAreInitializedUponStart() {
        assertNotEquals(null, viewModel.firstNumeratorProperty().get());
        assertNotEquals(null, viewModel.firstDenominatorProperty().get());
        assertNotEquals(null, viewModel.secondNumeratorProperty().get());
        assertNotEquals(null, viewModel.secondDenominatorProperty().get());
        assertNotEquals(null, viewModel.resultNumeratorProperty().get());
        assertNotEquals(null, viewModel.resultDenominatorProperty().get());
    }

    @Test
    public void statusIsReadyWhenFieldsAreFill() {
        setInputData();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsBadWhenFieldWrongFormat() {
        viewModel.firstNumeratorProperty().set("a");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingIfNotEnoughCorrectData() {
        viewModel.firstNumeratorProperty().set("1");

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWhenInit() {
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWhenFormatIsBad() {
        setInputData();
        viewModel.firstNumeratorProperty().set("b");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWithIncompleteInput() {
        viewModel.firstDenominatorProperty().set("1");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsEnabledWithCorrectInput() {
        setInputData();

        assertFalse(viewModel.calculationDisabledProperty().get());
    }

}
