package ru.unn.agile.binarysearch.viewmodel;

//import javafx.beans.binding.BooleanBinding;
//import javafx.beans.property.*;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import ru.unn.agile.binarysearch.model.BinarySearch;

//import java.util.ArrayList;
//import java.util.List;

public class ViewModel {

    private String arrayTextBoxValue;
    private String elementTextBoxValue;
    private String status;

    public ViewModel() {
        arrayTextBoxValue = "";
        elementTextBoxValue = "";
        status = "";
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

}
