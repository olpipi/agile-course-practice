package ru.unn.agile.numerical_integration.ViewModel.legacy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTests {
    @Test
    public void canCreateDefaultModel() {
        ViewModel model = new ViewModel();

        assertEquals("", model.getFunction());
        assertEquals("", model.getLeftBorderValue());
        assertEquals("", model.getRightBorderValue());
        assertEquals("", model.getSplitsCount());
        assertEquals("", model.getOutputMessage());
    }
}
