package ru.unn.agile.primenumber.viewModel;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.primenumber.infrastructure.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerTest {

    @Before
    public void initiateLogs(){
        LoggerFactory factory = mock(LoggerFactory.class);
        when(factory.getLogger()).thenReturn(new InMemoryLogger());
    }

    @Test
    public void canInitiateViewModel() {
        ViewModel viewModel = new ViewModel();

        assertEquals("Application is Started", viewModel.getLogs());
    }
}
