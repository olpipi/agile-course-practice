package ru.unn.agile.huffman.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HuffmanEncoding {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button encodeButton;

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    void initialize() {
        assert encodeButton != null : "fx:id=\"encodeButton\" was not injected: check your FXML file 'HuffmanEncoding.fxml'.";
        assert inputText != null : "fx:id=\"inputText\" was not injected: check your FXML file 'HuffmanEncoding.fxml'.";
        assert outputText != null : "fx:id=\"outputText\" was not injected: check your FXML file 'HuffmanEncoding.fxml'.";

    }
}