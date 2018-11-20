package ru.unn.agile.caesarcipher.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.caesarcipher.CaesarCipher;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    String inputTextBoxValue;
    String offsetTextBoxValua;
    String status;

}

public String getInputTaxtBoxValue()
{
    return inputTextBoxValue;
}

public String getOffsetTextBoxValua()
{
    return offsetTextBoxValua;
}

public String getStatus()
{
    return status;
}