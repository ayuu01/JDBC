package com.company;

import java.sql.*;
import java.util.Scanner;

public class EmployeeUtility {
    static Connection connection =JdbcConnection.createConnection();

    public static void createTable() throws SQLException {

        Statement statement=connection.createStatement();
        String empTable = "create table employee1(empId int,empFirstName char(20),empLastName char(20),empSalary int(20),empEmail char(20),empDesignation char(15),empReportTo int,empJoiningDate char(20))";


        String deptTable= "create table department1(id int, deptName char(10), city char(20))";

        statement.executeUpdate(empTable);
        statement.executeUpdate(deptTable);
        System.out.println("table created");
    }

    public static void insertEmployeeRecord() throws SQLException {
      //  Statement statement=connection.createStatement();
        System.out.println("Enter the records of employee table");
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Enter the empId");
            int empId = sc.nextInt();

            System.out.println("Enter the empFirstName");
            String empFirstName = sc.next();

            System.out.println("Enter the empLastName");
            String empLastName = sc.next();

            System.out.println("Enter the empSalary");
            int empSalary = sc.nextInt();

            System.out.println("Enter the empEmail");
            String empEmail = sc.next();

            System.out.println("Enter the empDesignation");
            String empDesignation = sc.next();

            System.out.println("Enter the empReportTo");
            String empReportTo = sc.next();

            System.out.println("Enter the empDateOfJoin");
            String dateOfJoin = sc.next();

            /*SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date empDateOfJoin=date.parse(dateOfJoin);
            long ms=empDateOfJoin.getTime();
            java.sql.Date empJoiningDate=new java.sql.Date(ms) ;*/


            //statement.executeUpdate("insert into employee1 values('" + empId + "','" + empFirstName + "','" + empLastName + "','" + empSalary + "','" + empEmail + "','" + empDesignation + "','" + empReportTo + "','" + dateOfJoin + "')");
            String query= "insert into employee1 values(empId+ empFirstName+ empLastName+empSalary +empEmail +empDesignation +empReportTo + empJoiningDate) values(?,?,?,?,?,?,?,?)";
                
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,empFirstName);
            statement.setString(3,empLastName);
            statement.setInt(4,empSalary);
            statement.setInt(5,empDesignation);
            statement.setInt(7,empReportTo);
            statement.setString(8,empJoiningDate);
                
            System.out.println("Are you want to insert more Record yes/no");
            String response = sc.next();

            if (response.equalsIgnoreCase("no"))
                break;
        }

    }
    public static void insertDepartmentRecord() throws SQLException  {
            
            System.out.println("Enter the records of department table");
            Scanner sc = new Scanner(System.in);
            while (true) {

                System.out.println("Enter the id");
                int id = sc.nextInt();

                System.out.println("Enter the deptName");
                String deptName = sc.next();

                System.out.println("Enter the city");
                String city = sc.next();
                
                String q= "insert into department1 values(id  + deptName  + city ) values(?,?,?)";
                
                PreparedStatement statement=connection.prepareStatement(q);
                statement.setInt(1,id);
                statement.setString(2,deptName);
                statement.setString(3,city);
                
                statement.executeUpdate();
                
                
                System.out.println("Are you want to insert more Record yes/no");
                String response = sc.next();

                if (response.equalsIgnoreCase("no"))
                    break;
            }

    }


    public static void display(ResultSet res) throws SQLException {
        Statement statement=connection.createStatement();
        while(res.next()){

            System.out.println(res.getInt(1)+ " "+res.getString(2)+" " +res.getString(3)+" "+res.getInt(4)+" "+res.getString(5)+" "
                    +res.getString(6)+" "+res.getString(7)+" "+res.getString(8));

        }
    }

    public static void empDetails() throws SQLException  {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r1 = statement.executeQuery("select empId, empFirstName, empLastName,  empEmail, empDesignation from employee1");
        while (r1.next()) {

            System.out.println(r1.getInt(1) + " " + r1.getString(2) + " " + r1.getString(3) + " " + r1.getString(4) + " " + r1.getString(5) + " ");
        }

    }


    public static void empDesignation() throws SQLException  {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r2 = statement.executeQuery("select * from employee1 where empDesignation = 'QAEngineer' or empDesignation = 'SDEngineer' ");
        display(r2);

    }

    public static void empReportTo() throws SQLException  {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r3 = statement.executeQuery("select empFirstName, empReportTo from employee1");
        while (r3.next()) {
            System.out.println(r3.getString(1) + " " + r3.getInt(2));
        }

    }

    public static void empNameStartWithA() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r4 = statement.executeQuery("select * from employee1 where empFirstName like 'A%'");
        display(r4);

    }

    public static void empsFiveHighestSalary() throws SQLException {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r5 = statement.executeQuery("select * from employee1 where(empSalary IN(select top(5) salary from employee1 group by empSalary order by empSalary desc))");
        display(r5);

    }

    public static void empSecondHighestSalary() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r6 = statement.executeQuery("select * from employee1 where empSalary = (select max(empSalary) from employee where empSalary<(select max(empSalary) from employee1))");
        display(r6);

    }

    public static void empSalaryLess() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r7 = statement.executeQuery("select * from employee1 where empSalary < (select max(empSalary) from employee where empSalary<(select max(empSalary) from employee1))");
        display(r7);

    }

    public static void empDepartment() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r8 = statement.executeQuery("select * from employee1 e join department1 d on (e.empId = d.id)");
        display(r8);

    }
    public static void empCityY() throws SQLException {

        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r9 = statement.executeQuery("select * from employee1 e join department1 d on (e.empId = d.id) where city = 'Y'");
        display(r9);
    }

    public static void empTotalSalary() throws SQLException {

        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r10 = statement.executeQuery("select sum (empSalary) from employee1");

        while (r10.next()) {
            System.out.println(r10.getInt(1));
        }
    }
    public static void empAvgSalary() throws SQLException {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r11 = statement.executeQuery("select avg (empSalary) from employee1 e join department d on e.empId = d.id and city = 'Y'");

        while (r11.next()) {
            System.out.println(r11.getInt(1));
        }
    }

    public static void empSalaryDeptWise() throws SQLException {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r12 = statement.executeQuery("select sum (empSalary) from employee1 e join department d on e.empid = d.id group by d.deptName");

        while (r12.next()) {
            System.out.println(r12.getInt(1));
        }

    }
}
