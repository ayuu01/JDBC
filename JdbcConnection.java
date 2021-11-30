package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {
    static Connection connection;

    public static Connection createConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcDb";
           // String url="jdbc:oracle:thin:@localhost:1521:xe";
            String user = "root";
            String pass = "Ayuagr01";

            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver  Loaded");

            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
