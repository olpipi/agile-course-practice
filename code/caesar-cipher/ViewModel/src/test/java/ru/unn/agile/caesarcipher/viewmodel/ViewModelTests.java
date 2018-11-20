package ru.unn.agile.caesarcipher.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.caesarcipher.model.CaesarCipher.Operation;

import static org.junit.Assert.*;

public class ViewModelTests {
    @Test
    public void canInitializeArrayValue()
    {
        ViewModel viewModel = new ViewModel();
        assertEquals("", viewModel.getInputTextBoxValue);
    }

    @Test
    public void canInitializeArrayValue()
    {
        ViewModel viewModel = new ViewModel();
        assertEquals("", viewModel.getOffsetTextBoxValua);
    }

    @Test
    public void canInitializeArrayValue()
    {
        ViewModel viewModel = new ViewModel();
        assertEquals("", viewModel.gatStatus);
    }

}

