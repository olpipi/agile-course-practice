package ru.unn.agile.binarysearch.viewmodel;

//import javafx.beans.binding.BooleanBinding;
//import javafx.beans.property.*;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import ru.unn.agile.binarysearch.model.BinarySearch;

//import java.util.ArrayList;
//import java.util.List;

public class ViewModel {

    private String arrayTextBoxValue;
    private String elementTextBoxValue;
    private String status;
    private BinarySearch search;
    private boolean arrayCorrect;
    private boolean elementCorrect;

    public ViewModel() {
        arrayTextBoxValue = "";
        elementTextBoxValue = "";
        status = "";
        search = null;
        arrayCorrect = false;
        elementCorrect = false;
    }

    public String getArrayTextBoxValue() {
        return arrayTextBoxValue;
    }

    public String getElementTextBoxValue() {
        return elementTextBoxValue;
    }

    public String getStatus() {
        return status;
    }

    public void setArrayTextBoxValue(final String input) {
        try {
            String[] split = input.split(",");
            int[] arr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            arrayCorrect = true;
            search = new BinarySearch(arr);

        } catch (NumberFormatException nfe) {
            status = "Invalid array entered";
            arrayCorrect = false;
            search = null;
        }
    }

    public int[] getBinarySearchArray() {
        return search.getArray();
    }

    public void setElementTextBoxValue(final String input) {
        try {
            Integer.parseInt(input);
            elementCorrect = true;
            elementTextBoxValue = input;
        } catch (NumberFormatException nfe) {
            status = "Invalid element entered";
            elementCorrect = false;
        }
    }

    public void search() {
        if (isSearchEnabled()) {
            int key = Integer.parseInt(elementTextBoxValue);
            int index = search.search(key);
            if (index == -1) {
                status = "Key not found";
            } else {
                status = "Found key, index " + Integer.toString(index);
            }
        }
    }

    public boolean isSearchEnabled() {
        return arrayCorrect && elementCorrect;
    }

}
