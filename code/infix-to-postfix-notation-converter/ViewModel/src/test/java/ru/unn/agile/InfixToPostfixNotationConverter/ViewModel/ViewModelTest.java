package ru.unn.agile.InfixToPostfixNotationConverter.ViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//import ru.unn.agile.InfixToPostfixNotationConverter.ViewModel.ViewModel;
//import ru.unn.agile.InfixToPostfixNotationConverter.ViewModel.Status;

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

    private void enterValidInputData() {
        viewModel.infixExpressionProperty().set("1+1");
    }

    private void enterInvalidInputData() {
        viewModel.infixExpressionProperty().set("trash");
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.infixExpressionProperty().get());
        assertEquals("", viewModel.postfixExpressionProperty().get());
        assertEquals("", viewModel.expressionResultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }
}

