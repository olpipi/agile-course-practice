package ru.unn.agile.numerical_integration.ViewModel.legacy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTests {
    @Test
    public void canCreateDefaultModel() {
        ViewModel model = new ViewModel();

        assertEquals("", model.getFunction());
        assertEquals("0.0", model.getLeftBorderValue());
        assertEquals("0.0", model.getRightBorderValue());
        assertEquals("0", model.getSplitsCount());
        assertEquals("", model.getOutputMessage());
    }
}
