package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.ecommerce.HelloApplication.emailid;
import static com.example.ecommerce.HelloApplication.username;


public class headerController {
    @FXML
    Label user;
    @FXML
    public void initialize(){
        if(!emailid.equals("")){
            loginButton.setVisible(false);
           // loginButton.setOpacity(0);
            email.setText(emailid);
            user.setText(username);
            signupButton.setVisible(false);
           // signupButton.setOpacity(0);
        }

    }

    @FXML
    Label email;
    @FXML
    Button loginButton, logoutButton, signupButton;
    @FXML
    TextField searchtext;

    public void login(MouseEvent e) throws IOException{
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        HelloApplication.root.getChildren().setAll(loginpage);   //better use setAll rather using add
    }

    public void search(MouseEvent e) throws SQLException, IOException {
        header head = new header();
        Productpage productpage = new Productpage();

        AnchorPane productpane = new AnchorPane();

        productpane.getChildren().add(productpage.productsbySearch(searchtext.getText()));

        productpane.setLayoutX(125);
        productpane.setLayoutY(125);

        HelloApplication.root.getChildren().clear();

        HelloApplication.root.getChildren().add(productpane);
        HelloApplication.root.getChildren().add(head.root);
    }

    public void logout(MouseEvent e) throws IOException, SQLException {
        emailid ="";
        logoutButton.setOpacity(0);


        header head = new header();
        Productpage productpage = new Productpage();
        AnchorPane productpane = new AnchorPane();

        productpane.setLayoutX(125);
        productpane.setLayoutY(125);

        //HelloApplication.root.getChildren().clear();

        productpane.getChildren().add(productpage.products());
        HelloApplication.root.getChildren().add(productpane);

        HelloApplication.root.getChildren().add(head.root);

        System.out.println("You are logout from buyer account");
    }

    public void signup(MouseEvent e) throws IOException{
        AnchorPane signuppage = FXMLLoader.load(getClass().getResource("signuppage.fxml"));
        HelloApplication.root.getChildren().setAll(signuppage);
    }
}
