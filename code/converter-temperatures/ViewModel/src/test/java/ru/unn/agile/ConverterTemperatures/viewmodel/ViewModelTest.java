package ru.unn.agile.ConverterTemperatures.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesUnit;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void initViewModel() {
        viewModel = new ViewModel();
    }

    @After
    public void nullViewModel() {
        viewModel = null;
    }

    @Test
    public void createEmptyViewModel() {
        assertEquals("", viewModel.convertFromProperty().get());
        assertEquals(TemperaturesUnit.FAHRENHEIT, viewModel.getScale());
        assertEquals("", viewModel.convertToProperty().get());
        assertEquals(Status.READY.toString(), viewModel.getStatus());
    }

    @Test
    public void canAddValueToConvert() {
        viewModel.convertFromProperty().set("10.0");
        viewModel.updateInputValues();

        assertEquals("10.0", viewModel.convertFromProperty().get());
        assertEquals(Status.READY.toString(), viewModel.getStatus());
    }

    @Test
    public void canProcessBadInputFormat() {
        viewModel.convertFromProperty().set("a");
        viewModel.updateInputValues();

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.getStatus());
    }

}
