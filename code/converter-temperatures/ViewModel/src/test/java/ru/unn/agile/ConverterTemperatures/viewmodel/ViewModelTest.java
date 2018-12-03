package ru.unn.agile.ConverterTemperatures.viewmodel;

import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesUnit;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    @Test
    public void createEmptyViewModel() {
        ViewModel viewModel = new ViewModel();
        assertEquals("", viewModel.getConvertFrom());
        assertEquals(TemperaturesUnit.FAHRENHEIT, viewModel.getScale());
        assertEquals("", viewModel.getConvertTo());
        assertEquals(Status.READY.toString(), viewModel.getStatus());
    }
}
