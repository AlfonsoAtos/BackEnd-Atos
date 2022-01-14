package com.backend.webproject;

import java.sql.*;

public class OracleConnection {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "dev_carlos123";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Oracle driver loaded successfully");
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Database '" + con + "' connected");

                /*
                 * String query = "select * from coupon";
                 * Statement stmt = con.createStatement();
                 * stmt.execute(query);
                 * System.out.println("Query successful");
                 */
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
