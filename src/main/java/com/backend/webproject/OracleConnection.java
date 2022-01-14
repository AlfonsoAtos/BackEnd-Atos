package com.backend.webproject;

import java.sql.*;

public class OracleConnection {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521/XE";
        String user = "system";
        String password = "edu511";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver is loaded successfuly");
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Driver is successful with " + con);

                String query = "select * from coupon";
                Statement stmt = con.createStatement();
                stmt.execute(query);
                System.out.println("Query successful");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
