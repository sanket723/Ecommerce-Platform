package com.example.ecommerce;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.ecommerce.HelloApplication.root;

public class SellerpageController {
    @FXML
    TextField name,price,sellerid;

    @FXML
    public void addproduct(MouseEvent e) throws IOException, SQLException {

        int productid = 1;

        ResultSet res = HelloApplication.connection.executeQuery("Select max(productid) as productid from product;");
        if(res.next()){
            productid = res.getInt("productid") + 1 ;
            System.out.println("productid now " + productid);
        }

        String query = String.format("insert into product values(%s,'%s',%s,'%s')",productid,name.getText(),price.getText(),sellerid.getText());
        int response = HelloApplication.connection.executeUpdate(query);

        if(response>0){
            System.out.println("New Product is Added");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Product Status");
            alert.setContentText("New Product is Added in the Product Page.");
            alert.showAndWait();
        }


    }



}
