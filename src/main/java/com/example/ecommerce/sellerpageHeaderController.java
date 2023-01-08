package com.example.ecommerce;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.ecommerce.HelloApplication.emailid;
import static com.example.ecommerce.HelloApplication.username;


public class sellerpageHeaderController {

    @FXML
    Label user;
    @FXML
    Label email;
    @FXML
    Button logoutButton;

    public void initialize(){
        if(!emailid.equals("")){
            user.setText(username);
            email.setText(emailid);
        }
    }

    public void logout(MouseEvent e) throws IOException, SQLException {
        emailid ="";
        logoutButton.setOpacity(0);


        header head = new header();
        Productpage productpage = new Productpage();
        AnchorPane productpane = new AnchorPane();

        productpane.setLayoutX(125);
        productpane.setLayoutY(125);

        HelloApplication.root.getChildren().clear();

        productpane.getChildren().add(productpage.products());
        HelloApplication.root.getChildren().add(productpane);

        HelloApplication.root.getChildren().add(head.root);

        System.out.println("You are logout from seller account");
    }

}
