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

    @Test
    public void canSetArrayValue() {
        ViewModel viewModel = new ViewModel();
        int[] expected = new int[] {1, 2, 3};

        viewModel.setArrayTextBoxValue("1,2,3");

        assertArrayEquals(expected, viewModel.getBinarySearchArray());
    }

    @Test
    public void canSetElementValue() {
        ViewModel viewModel = new ViewModel();
        String expected = "2";

        viewModel.setElementTextBoxValue("2");

        assertEquals(expected, viewModel.getElementTextBoxValue());
    }

}
