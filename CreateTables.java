package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    static Connection connection =JdbcConnection.createConnection();

    public  void createTable() throws SQLException {

        Statement statement=connection.createStatement();
        String empTable = "create table employee1(empId int,empFirstName varchar(20),empLastName varchar(20),empSalary int,empEmail varchar(20),empDesignation varchar(15),empReportTo varchar(20),empJoiningDate date)";


        String deptTable= "create table department1(id int, name varchar(10), city varchar(20))";

        statement.executeUpdate(empTable);
        statement.executeUpdate(deptTable);
        System.out.println("table created");
    }

}
