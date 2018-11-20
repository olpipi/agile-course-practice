package ru.unn.agile.binarysearch.viewmodel;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
//import ru.unn.agile.binarysearch.model.BinarySearch;

import static org.junit.Assert.*;

public class ViewModelTests {

    @Test
    public void canInitializeArrayValue() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getArrayTextBoxValue());
    }

    @Test
    public void canInitializeElementValue() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getElementTextBoxValue());
    }

    @Test
    public void canInitializeStatus() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getStatus());
    }

}
