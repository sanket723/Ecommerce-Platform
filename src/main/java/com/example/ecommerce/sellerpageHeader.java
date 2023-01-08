package com.example.ecommerce;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class sellerpageHeader {
    public AnchorPane root;
    sellerpageHeader() throws IOException {
        root = FXMLLoader.load(getClass().getResource("sellerpageHeader.fxml"));

    }
}
