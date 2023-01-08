package com.example.ecommerce;

import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static com.example.ecommerce.HelloApplication.emailid;

public class Order {

    void placeOrder(String productid) throws SQLException {
        ResultSet res = HelloApplication.connection.executeQuery("select max(orderid) as orderid from orders");
        int orderid = 1;
        if(res.next()){
            orderid = res.getInt("orderid") + 1 ;
        }

        Timestamp datetime = new Timestamp(System.currentTimeMillis());

        String query = String.format("insert into orders values(%s,%s,'%s','%s')",orderid,productid,emailid,datetime);
        int response = HelloApplication.connection.executeUpdate(query);


        if(response>0) {
            System.out.println("Order is Placed");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Status");
            alert.setContentText("Order is Placed Successfully.");
            alert.showAndWait();
        }
            else{
                System.out.println("Order Not Placed");
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Order Status");
               alert.setContentText("Order is not Placed. Please replace the order");
               alert.showAndWait();
        }

    }
}
