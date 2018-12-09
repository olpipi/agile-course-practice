package ru.unn.agile.numerical_integration.viewmodel.legacy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelLoggingTests {
    private ViewModel viewModel;
    private ILogger logger;

    @Before
    public void setUp() throws Exception {
        viewModel = new ViewModel();
        logger = new FakeLogger();
        viewModel.setLogger(logger);
    }
    @After
    public void tearDown() throws Exception {
        logger.close();
        logger = null;
        viewModel = null;
    }

    @Test
    public void canSetLogger() {
        assertNotEquals(viewModel.getLogger(), null);
    }

    @Test
    public void canLogComputeClick() {
        fail();
    }

}
