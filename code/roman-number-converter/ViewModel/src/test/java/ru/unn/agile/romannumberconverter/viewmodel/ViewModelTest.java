package ru.unn.agile.romannumberconverter.viewmodel;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void createViewModel() {
        viewModel = new ViewModel();
    }

    @After
    public void deleteViewModel() {
        viewModel = null;
    }

    @Test
    public void initViewModelWithDefaultValues() {
        assertEquals("", viewModel.getArabicValueStr());
        assertEquals("", viewModel.getRomanValueStr());
    }

    @Test
    public void canAllFieldsBeSetted() {
        viewModel.setArabicValueStr("1");
        viewModel.setRomanValueStr("1");

        assertEquals("1", viewModel.getArabicValueStr());
        assertEquals("1", viewModel.getRomanValueStr());
    }

    @Test
    public void canConvertArabicToRomanValidValue() {
        viewModel.setArabicValueStr("11");

        viewModel.convertArabicToRoman();

        assertEquals("XI",viewModel.getRomanValueStr());
    }

    @Test
    public void canConvertArabicToRomanInvalidValue() {
        viewModel.setArabicValueStr("test");

        viewModel.convertArabicToRoman();

        assertEquals("Арабское число введено неверно!", viewModel.getConvertStatus());
    }
}
