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

        assertEquals("", viewModel.getArrayInputProperty());
    }

    @Test
    public void canInitializeElementValue() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getElementInputProperty());
    }

    @Test
    public void canInitializeStatus() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getStatusProperty());
    }

    @Test
    public void canSetArrayValue() {
        ViewModel viewModel = new ViewModel();
        int[] expected = new int[] {1, 2, 3};

        viewModel.setArrayInputProperty("1,2,3");

        assertArrayEquals(expected, viewModel.getBinarySearchArray());
    }

    @Test
    public void canSetElementValue() {
        ViewModel viewModel = new ViewModel();
        String expected = "2";

        viewModel.setElementInputProperty("2");

        assertEquals(expected, viewModel.getElementInputProperty());
    }

    @Test
    public void canFindExistingKey() {
        ViewModel viewModel = new ViewModel();
        String expected = "Found key, index 1";

        viewModel.setArrayInputProperty("1,2,3");
        viewModel.setElementInputProperty("2");
        viewModel.search();

        assertEquals(expected, viewModel.getResultProperty());
    }

    @Test
    public void isSearchEnabledWithCorrectInput() {
        ViewModel viewModel = new ViewModel();

        viewModel.setArrayInputProperty("1,2,3");
        viewModel.setElementInputProperty("2");

        assertEquals(false, viewModel.isSearchDisabled());
    }

    @Test
    public void isSearchEnabledWithIncorrectArrayInput() {
        ViewModel viewModel = new ViewModel();

        viewModel.setArrayInputProperty("1yh,p2,_0w3");
        viewModel.setElementInputProperty("2");

        assertEquals(true, viewModel.isSearchDisabled());
    }

    @Test
    public void isSearchEnabledWithIncorrectElementInput() {
        ViewModel viewModel = new ViewModel();

        viewModel.setArrayInputProperty("1,2,3");
        viewModel.setElementInputProperty("h");

        assertEquals(true, viewModel.isSearchDisabled());
    }

    @Test
    public void isSearchEnabledWithEmptyInput() {
        ViewModel viewModel = new ViewModel();

        viewModel.setArrayInputProperty("");
        viewModel.setElementInputProperty("");

        assertEquals(true, viewModel.isSearchDisabled());
    }

    @Test
    public void isSearchEnabledWithUnsortedArray() {
        ViewModel viewModel = new ViewModel();

        viewModel.setArrayInputProperty("1,0,-1");

        assertEquals(true, viewModel.isSearchDisabled());
    }
}
