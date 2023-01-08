package com.example.ecommerce;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {
    public static databaseConnection connection;
    public static Group root;
    public static String emailid;
    public static String username;

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        emailid ="";
        username="";
        connection = new databaseConnection();
        root = new Group();

        header head = new header();
        Productpage productpage = new Productpage();
        AnchorPane productpane = new AnchorPane();

        productpane.setLayoutX(125);
        productpane.setLayoutY(125);

        productpane.getChildren().add(productpage.products());
        root.getChildren().add(productpane);

        root.getChildren().add(head.root);


        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("ECOMMERCE");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e ->{
            try {
                connection.con.close();
                System.out.println("Connection is closed.");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}