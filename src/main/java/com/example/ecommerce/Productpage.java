package com.example.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.ecommerce.HelloApplication.emailid;

public class Productpage {
     ListView<HBox> products ;

    ListView<HBox> productsbySearch(String search) throws SQLException {

        products = new ListView<>();

        ObservableList<HBox> productlist = FXCollections.observableArrayList();

        ResultSet res = HelloApplication.connection.executeQuery("Select * from product");

        while(res.next()){
           if(res.getString("productname").toLowerCase().contains(search.toLowerCase())){
               Label productid = new Label();
               Label name = new Label();
               Label price = new Label();
               Button buy = new Button();

               buy.setOnAction(new EventHandler<ActionEvent>() {
                   @Override
                   public void handle(ActionEvent actionEvent) {
                       System.out.println("Buy button is clicked");
                       if(emailid.equals("")){
                           System.out.println("Please Login First to Buy");
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                           alert.setTitle("Login Reminder");
                           alert.setContentText("Please Login First to Buy Products.");
                           alert.showAndWait();
                       }
                       else{
                           System.out.println("Logged in with " + emailid);
                           Order orders = new Order();
                           try {
                               orders.placeOrder(productid.getText());
                           } catch (SQLException e) {
                               throw new RuntimeException(e);
                           }
                       }
                   }
               });

               productid.setMinWidth(20);
               name.setMinWidth(65);
               price.setMinWidth(65);

               HBox productdetails = new HBox();

               productid.setText(res.getString("productid"));
               name.setText(res.getString("productName"));
               price.setText(res.getString("productPrice"));
               buy.setText("Buy");

               productdetails.getChildren().addAll(productid,name,price,buy);
               productlist.add(productdetails);
           }
        }
        products.setItems(productlist);
        return products;
    }



     ListView<HBox> products() throws SQLException {

          products = new ListView<>();

         ObservableList<HBox> productlist = FXCollections.observableArrayList();

        ResultSet res = HelloApplication.connection.executeQuery("Select * from product");

        while(res.next()){
            Label productid = new Label();
            Label name = new Label();
            Label price = new Label();
            Button buy = new Button();

            buy.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Buy button is clicked");
                    if(emailid.equals("")){
                        System.out.println("Please Login First to Buy");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login Reminder");
                        alert.setContentText("Please Login First to Buy Products.");
                        alert.showAndWait();
                    }
                    else{
                        System.out.println("Logged in with " + emailid);
                        Order orders = new Order();
                        try {
                            orders.placeOrder(productid.getText());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });

            productid.setMinWidth(20);
            name.setMinWidth(65);
            price.setMinWidth(65);

            HBox productdetails = new HBox();

            productid.setText(res.getString("productid"));
            name.setText(res.getString("productName"));
            price.setText(res.getString("productPrice"));
            buy.setText("Buy");

            productdetails.getChildren().addAll(productid,name,price,buy);
            productlist.add(productdetails);
        }
        products.setItems(productlist);
        return products;

    }
}
