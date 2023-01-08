package com.example.ecommerce;

import java.sql.*;

public class databaseConnection {

    Connection con = null;
    String SQLURL = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
    String username = "root";
    String password = "Sanket@23";
    databaseConnection() throws SQLException {
        con= DriverManager.getConnection(SQLURL,username,password);

        if(con!=null)
            System.out.println("Connection is established with database succesfully");
    }

    //"Select * from table_name"
    public ResultSet executeQuery(String query) throws SQLException {

        ResultSet result = null;

        try {
            Statement statement = con.createStatement();
            result = statement.executeQuery(query);
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //"Insert into table_name values(...)"
    public int executeUpdate(String query) throws SQLException {

        int row = 0;
        try {
            Statement statement = con.createStatement();
            row = statement.executeUpdate(query);

            return row;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

}


