package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.ecommerce.HelloApplication.emailid;
import static com.example.ecommerce.HelloApplication.username;

public class loginpageController {

    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    public void login(MouseEvent e) throws IOException, SQLException {
       String query = String.format("Select * from user where emailid='%s' and pass='%s' ",email.getText(),password.getText());

        ResultSet res = HelloApplication.connection.executeQuery(query);

        if(res.next()){
            emailid = res.getString("emailid");
            username = res.getString("username");
            System.out.println("User is present in user table");
            String usertype = res.getString("userType");

            if(usertype.equals("Seller")) {
                AnchorPane sellerpage = FXMLLoader.load(getClass().getResource("Sellerpage.fxml"));
                HelloApplication.root.getChildren().add(sellerpage);
                System.out.println("Logged in as Seller");
                sellerpageHeader head = new sellerpageHeader();
                HelloApplication.root.getChildren().add(head.root);
            }

            else{
                System.out.println("Logged in as Buyer");

                    header head = new header();
                    Productpage productpage = new Productpage();

                    AnchorPane productpane = new AnchorPane();

                    productpane.getChildren().add(productpage.products());

                    productpane.setLayoutX(125);
                    productpane.setLayoutY(125);

                    HelloApplication.root.getChildren().clear();

                    HelloApplication.root.getChildren().add(productpane);
                    HelloApplication.root.getChildren().add(head.root);
              }

        }

        else{
            System.out.println("User is not present");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Status");
            alert.setContentText("Incorrect Credential. Please enter correct email and password. ");
            alert.showAndWait();
        }

    }

    @FXML
    Button homeButton;
    public void home(MouseEvent e) throws IOException, SQLException {
//        emailid ="";
//        Home.setOpacity(0);


        header head = new header();
        Productpage productpage = new Productpage();
        AnchorPane productpane = new AnchorPane();

        productpane.setLayoutX(125);
        productpane.setLayoutY(125);

        HelloApplication.root.getChildren().clear();

        productpane.getChildren().add(productpage.products());
        HelloApplication.root.getChildren().add(productpane);

        HelloApplication.root.getChildren().add(head.root);

        System.out.println("You are at home page");
    }

 }
