package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;

public class signuppageController {

    @FXML
    TextField email,username,password,usertype;
    @FXML
    public void signup(MouseEvent e) throws IOException, SQLException{

            String query = String.format("insert into user values('%s','%s','%s','%s')", email.getText(), username.getText(), password.getText(), usertype.getText());
            int response = HelloApplication.connection.executeUpdate(query);

            if (response > 0) {
                System.out.println("New Account created Successfully");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SignUp Status");
                alert.setContentText("New user account created successfully.");
                alert.showAndWait();
            }
            else {
                System.out.println("Account creation failed");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SignUp Status");
                alert.setContentText("User is already present. Please try different email.");
                alert.showAndWait();
            }
    }

    @FXML
    Label loginButton;
    public void login(MouseEvent e) throws IOException {
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        HelloApplication.root.getChildren().setAll(loginpage);
    }

}
