package ru.unn.agile.numberinwords.viewmodel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumbersInWordsViewModelTests {
    @Test
    public void byDefaultConvertButtonIsDisabled() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenEnterNumberConvertButtonIsEnabled() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("1");

        assertTrue(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenClearNumberConvertButtonIsDisabled() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("1");
        viewModel.setNumber("");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenConvertNumber1DisplayNumberOne() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("1");
        viewModel.convert();

        assertEquals("One", viewModel.getNumberInWords());
    }

    @Test
    public void whenDeletedNumberDeletedNumberInWords() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("1");
        viewModel.convert();
        viewModel.setNumber("2");

        assertEquals("", viewModel.deleteNumberInWords());
    }

    @Test
    public void whenEnterInvalidNumberConvertButtonIsDisabled() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("a");

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void whenEnterInvalidNumberShowErrorMessage() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("a");

        assertEquals("Only digits, please", viewModel.getErrorMessage());
    }

    @Test
    public void whenCorrectInvalidNumberHideErrorMessage() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("a");
        viewModel.setNumber("1");

        assertEquals("", viewModel.getErrorMessage());
    }

    @Test
    public void whenCleanInvalidNumberHideErrorMessage() {
        NumbersInWordsViewModel viewModel = new NumbersInWordsViewModel();

        viewModel.setNumber("a");
        viewModel.setNumber("");

        assertEquals("", viewModel.getErrorMessage());
    }
}
