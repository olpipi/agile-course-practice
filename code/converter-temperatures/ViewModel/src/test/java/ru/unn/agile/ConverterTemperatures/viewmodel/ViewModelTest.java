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
        assertEquals("", viewModel.getConvertTo());
        assertEquals(Status.READY.toString(), viewModel.getStatus());
    }

    @Test
    public void canAddValueToConvert() {
        viewModel.convertFromProperty().set("10.0");
        viewModel.checkInputValues();

        assertEquals("10.0", viewModel.convertFromProperty().get());
        assertEquals(Status.READY.toString(), viewModel.getStatus());
    }

    @Test
    public void canProcessBadInputFormat() {
        viewModel.convertFromProperty().set("a");
        viewModel.checkInputValues();

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.getStatus());
    }

    @Test
    public void canConvertToFahrenheit() {
        viewModel.convertFromProperty().set("20.0");
        viewModel.scaleProperty().setValue(TemperaturesUnit.FAHRENHEIT);

        viewModel.convert();

        assertEquals("68.0", viewModel.getConvertTo());
        assertEquals(Status.SUCCESS.toString(), viewModel.getStatus());
    }

    @Test
    public void canConvertToKelvin() {
        viewModel.convertFromProperty().set("20.0");
        viewModel.scaleProperty().setValue(TemperaturesUnit.KELVIN);

        viewModel.convert();

        assertEquals("293.15", viewModel.getConvertTo());
        assertEquals(Status.SUCCESS.toString(), viewModel.getStatus());
    }

    @Test
    public void canConvertToNewton() {
        viewModel.convertFromProperty().set("20.0");
        viewModel.scaleProperty().setValue(TemperaturesUnit.NEWTON);

        viewModel.convert();

        assertEquals("6.6000000000000005", viewModel.getConvertTo());
        assertEquals(Status.SUCCESS.toString(), viewModel.getStatus());
    }

    @Test
    public void getExceptionFromConvert() {
        viewModel.convertFromProperty().set("-300.0");
        viewModel.scaleProperty().setValue(TemperaturesUnit.FAHRENHEIT);

        viewModel.convert();

        assertEquals(Status.ERROR.toString(), viewModel.getStatus());
    }
}
