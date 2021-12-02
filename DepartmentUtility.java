package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentUtility {
    static Connection connection =JdbcConnection.createConnection();

    public void insertDepartmentRecord() throws SQLException {

        System.out.println("Enter the records of department table");
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Enter the id");
            int id = sc.nextInt();

            System.out.println("Enter the deptName");
            String name = sc.next();

            System.out.println("Enter the city");
            String city = sc.next();

            String q= "insert into department1 (id  , name  , city ) values(?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(q);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,city);

            preparedStatement.executeUpdate();


            System.out.println("Are you want to insert more Record yes/no");
            String response = sc.next();

            if (response.equalsIgnoreCase("no"))
                break;
        }

    }
    /*public static void insertDepartmentRecord() throws SQLException  {
        Statement statement=connection.createStatement();
        System.out.println("Enter the records of department table");
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Enter the id");
            int id = sc.nextInt();

            System.out.println("Enter the name");
            String name = sc.next();

            System.out.println("Enter the city");
            String city = sc.next();

            statement.executeUpdate("insert into department1 values('" + id + "','" + name + "','" + city + "')");

            System.out.println("Are you want to insert more Record yes/no");
            String response = sc.next();

            if (response.equalsIgnoreCase("no"))
                break;
        }*/


}
