package ru.unn.agile.fraction.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.unn.agile.fraction.model.Fraction.Operation;

import java.util.Arrays;

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

}
