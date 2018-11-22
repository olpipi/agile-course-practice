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

    @Test
    public void canSetAddOperation() {
        viewModel.operationProperty().set(Operation.ADD);

        assertEquals(Operation.ADD, viewModel.operationProperty().get());
    }

    @Test
    public void addIsDefaultOperation() {
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
    }

    @Test
    public void canCalculateWithEmptyFieldsAndStatusWaiting() {
        viewModel.calculate();

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void operationAddHasCorrectResult() {
        viewModel.firstNumeratorProperty().set("1");
        viewModel.firstDenominatorProperty().set("2");
        viewModel.secondNumeratorProperty().set("1");
        viewModel.secondDenominatorProperty().set("3");

        viewModel.calculate();

        assertEquals("5", viewModel.resultNumeratorProperty().get());
        assertEquals("6", viewModel.resultDenominatorProperty().get());
    }

    @Test
    public void canSetSuccessMessage() {
        setInputData();

        viewModel.calculate();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canSetBadFormatMessage() {
        viewModel.secondNumeratorProperty().set("c");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenSetCorrectData() {
        setInputData();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void operationSubstractHasCorrectResult() {
        viewModel.firstNumeratorProperty().set("4");
        viewModel.firstDenominatorProperty().set("5");
        viewModel.secondNumeratorProperty().set("5");
        viewModel.secondDenominatorProperty().set("13");
        viewModel.operationProperty().set(Operation.SUBSTRACT);

        viewModel.calculate();

        assertEquals("27", viewModel.resultNumeratorProperty().get());
        assertEquals("65", viewModel.resultDenominatorProperty().get());
    }

    @Test
    public void operationMultiplyHasCorrectResult() {
        viewModel.firstNumeratorProperty().set("3");
        viewModel.firstDenominatorProperty().set("4");
        viewModel.secondNumeratorProperty().set("2");
        viewModel.secondDenominatorProperty().set("7");
        viewModel.operationProperty().set(Operation.MULTIPLY);

        viewModel.calculate();

        assertEquals("3", viewModel.resultNumeratorProperty().get());
        assertEquals("14", viewModel.resultDenominatorProperty().get());
    }

    @Test
    public void operationDivideHasCorrectResult() {
        viewModel.firstNumeratorProperty().set("13");
        viewModel.firstDenominatorProperty().set("44");
        viewModel.secondNumeratorProperty().set("23");
        viewModel.secondDenominatorProperty().set("22");
        viewModel.operationProperty().set(Operation.DIVIDE);

        viewModel.calculate();

        assertEquals("13", viewModel.resultNumeratorProperty().get());
        assertEquals("46", viewModel.resultDenominatorProperty().get());
    }
}
