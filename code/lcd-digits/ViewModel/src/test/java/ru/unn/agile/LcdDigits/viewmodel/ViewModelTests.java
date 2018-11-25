package ru.unn.agile.LcdDigits.viewmodel;

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
        assertEquals("", viewModel.digitsProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingWhenFieldIsEmpty() {
        viewModel.transformLcdDigits();

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenFieldIsFilled() {
        setInputDigits();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canRecognizeBadFormat() {
        viewModel.digitsProperty().set("qwerty");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void transferringButtonIsDisabledInitially() {
        assertTrue(viewModel.transferringDisabledProperty().get());
    }

    @Test
    public void transferringButtonIsDisabledWhenFieldIsEmpty() {
        viewModel.digitsProperty().set("");

        assertTrue(viewModel.transferringDisabledProperty().get());
    }

    @Test
    public void transferringButtonIsDisabledWhenFormatIsBad() {
        viewModel.digitsProperty().set("trash");

        assertTrue(viewModel.transferringDisabledProperty().get());
    }

    @Test
    public void transferringButtonIsEnabledWithCorrectInput() {
        setInputDigits();

        assertFalse(viewModel.transferringDisabledProperty().get());
    }

    @Test
    public void transferringButtonIsEnabledWhenTransferredCorrectly() {
        setInputDigits();

        viewModel.transformLcdDigits();

        assertFalse(viewModel.transferringDisabledProperty().get());
    }

    @Test
    public void statusSuccessWhenTransferredCorrectly() {
        setInputDigits();

        viewModel.transformLcdDigits();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void transferringHasCorrectResultOneDigit() {
        viewModel.digitsProperty().set("3");

        viewModel.transformLcdDigits();

        assertEquals("._. \n._| \n._| \n", viewModel.resultProperty().get());
    }

    @Test
    public void transferringHasCorrectResultLong() {
        viewModel.digitsProperty().set("1234567890");

        viewModel.transformLcdDigits();

        assertEquals("... ._. ._. ... ._. ._. ._. ._. ._. ._. \n"
                + "..| ._| ._| |_| |_. |_. ..| |_| |_| |.| \n"
                + "..| |_. ._| ..| ._| |_| ..| |_| ..| |_| \n", viewModel.resultProperty().get());
    }

    private void setInputDigits() {
        viewModel.digitsProperty().set("1234");
    }
}
