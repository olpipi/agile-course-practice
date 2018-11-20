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

    public ViewModel() {
        arrayTextBoxValue = "";
        elementTextBoxValue = "";
        status = "";
        search = null;
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
        String[] split = input.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        search = new BinarySearch(arr);
    }

    public int[] getBinarySearchArray() {
        return search.getArray();
    }

    public void setElementTextBoxValue(final String input) {
        elementTextBoxValue = input;
    }

}
