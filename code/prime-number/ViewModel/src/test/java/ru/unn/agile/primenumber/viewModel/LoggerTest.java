package ru.unn.agile.primenumber.viewModel;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.primenumber.infrastructure.InMemoryLogger;
import ru.unn.agile.primenumber.infrastructure.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerTest {

    private ViewModel viewModel;

    @Before
    public void initiateLogs() {
        LoggerFactory factory = mock(LoggerFactory.class);
        when(factory.getLogger()).thenReturn(new InMemoryLogger());
        viewModel = new ViewModel();
        viewModel.setLogger(factory);
    }

    @Test
    public void canInitiateViewModel() {
        assertEquals("Application is Started", viewModel.getLogs());
    }

    @Test
    public void canSetNullLoggerFactory() {
        try {
            viewModel.setLogger(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Logger Factory parameter can't be null", e.getMessage());
        }
    }

    @Test
    public void canLoggingRightProperty() {
        viewModel.setRightBound("a");

        viewModel.onFocusChanged(true, false);

        assertEquals("Application is Started\n"
                + "Current Sate: left bound = ,"
                + " right bound = a",
                viewModel.getLogs());
    }

    @Test
    public void canLoggingLeftProperty() {
        viewModel.setLeftBound("1");

        viewModel.onFocusChanged(true, false);

        assertEquals(
                "Application is Started\n"
                        + "Current Sate: left bound = 1,"
                        + " right bound = ",
                viewModel.getLogs());
    }

    @Test
    public void canLoggingSearch() {
        viewModel.setLeftBound("1");
        viewModel.setRightBound("4");

        viewModel.searchPrimeNumber();

        assertEquals(
                "Application is Started\n"
                        + "Calculation is started with parameters:"
                        + " left bound = 1 ,"
                        + " right bound = 4\n"
                        + "Calculation is finished with: status:"
                        + " Success and result: 2, 3",
                viewModel.getLogs());
    }

    @Test
    public void canLoggingE2E() {
        viewModel.setLeftBound("2");
        viewModel.setRightBound("5");
        viewModel.onFocusChanged(true, false);
        viewModel.searchPrimeNumber();

        assertEquals(
                "Application is Started\n"
                        + "Current Sate:"
                        + " left bound = 2, right bound = 5\n"
                        + "Calculation is started with parameters:"
                        + " left bound = 2 , right bound = 5\n"
                        + "Calculation is finished with:"
                        + " status: Success and result: 2, 3, 5",
                viewModel.getLogs());
    }

    @Test
    public void canLoggingE2EWithIncorrectNumbers() {
        viewModel.setLeftBound("2");
        viewModel.setRightBound("a");

        viewModel.onFocusChanged(true, false);
        viewModel.searchPrimeNumber();

        assertEquals(
                "Application is Started\n"
                        + "Current Sate:"
                        + " left bound = 2,"
                        + " right bound = a\n"
                        + "Calculation is started with parameters:"
                        + " left bound = 2 ,"
                        + " right bound = a\n"
                        + "Calculation is finished with: status:"
                        + " For input string: \"a\" and result: ",
                viewModel.getLogs());
    }

    @Test
    public void canLoggingE2EWithIncorrectInterval() {
        viewModel.setLeftBound("4");
        viewModel.setRightBound("1");

        viewModel.onFocusChanged(true, false);
        viewModel.searchPrimeNumber();

        assertEquals(
                "Application is Started\n"
                        + "Current Sate: left bound = 4, right bound = 1\n"
                        + "Calculation is started with parameters:"
                        + " left bound = 4 ,"
                        + " right bound = 1\n"
                        + "Calculation is finished with: status:"
                        + " Last value must be more or equal to first value! and result: ",
                viewModel.getLogs());
    }
}
