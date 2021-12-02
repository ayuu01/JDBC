package com.company;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmployeeUtility {
    static Connection connection =JdbcConnection.createConnection();



   /* public static void insertEmployeeRecord() throws SQLException {
        Statement statement=connection.createStatement();
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

            SimpleDateFormat dateOfJoin=new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date empDateOfJoin=date.parse(dateOfJoin);
            long ms=empDateOfJoin.getTime();
            java.sql.Date empJoiningDate=new java.sql.Date(ms) ;


            statement.executeUpdate("insert into employee1 values('" + empId + "','" + empFirstName + "','" + empLastName + "','" + empSalary + "','" + empEmail + "','" + empDesignation + "','" + empReportTo + "','" + empJoiningDate + "')");

            System.out.println("Are you want to insert more Record yes/no");
            String response = sc.next();

            if (response.equalsIgnoreCase("no"))
                break;
        }

    }
.

    }*/

   public  void insertEmployeeRecord() throws SQLException, ParseException {

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

                  SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
                  java.util.Date empDateOfJoin=date.parse(dateOfJoin);
                  long ms=empDateOfJoin.getTime();
                  java.sql.Date empJoiningDate=new java.sql.Date(ms) ;

                  String query= "insert into employee1 (empId, empFirstName,empLastName,empSalary ,empEmail ,empDesignation ,empReportTo ,empJoiningDate ) values(?,?,?,?,?,?,?,?)";

                  PreparedStatement preparedStatement=connection.prepareStatement(query);

                  preparedStatement.setInt(1,empId);
                  preparedStatement.setString(2,empFirstName);
                  preparedStatement.setString(3,empLastName);
                  preparedStatement.setInt(4,empSalary);
                  preparedStatement.setString(5,empEmail);
                  preparedStatement.setString(6,empDesignation);
                  preparedStatement.setString(7,empReportTo);
                  preparedStatement.setDate(8,empJoiningDate);

                  preparedStatement.executeUpdate();

                  System.out.println("Are you want to insert more Record yes/no");
                  String response = sc.next();

                  if (response.equalsIgnoreCase("no"))
                      break;
              }
   }


    public  void display(ResultSet res) throws SQLException {
        Statement statement=connection.createStatement();
        while(res.next()){

            System.out.println(res.getInt(1)+ " "+res.getString(2)+" " +res.getString(3)+" "+res.getInt(4)+" "+res.getString(5)+" "
                    +res.getString(6)+" "+res.getString(7)+" "+res.getString(8));

        }
    }

    public  void empDetails() throws SQLException  {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r1 = statement.executeQuery("select empId, empFirstName, empLastName,  empEmail, empDesignation from employee1");
        while (r1.next()) {

            System.out.println(r1.getInt(1) + " " + r1.getString(2) + " " + r1.getString(3) + " " + r1.getString(4) + " " + r1.getString(5) + " ");
        }

    }


    public  void empDesignation() throws SQLException  {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r2 = statement.executeQuery("select * from employee1 where empDesignation = 'QAEngineer' or empDesignation = 'SDEngineer' ");
        display(r2);

    }

    public  void empReportTo() throws SQLException  {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r3 = statement.executeQuery("select empFirstName, empReportTo from employee1");
        while (r3.next()) {
            System.out.println(r3.getString(1) + " " + r3.getString(2));
        }

    }

    public  void empNameStartWithA() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r4 = statement.executeQuery("select * from employee1 where empFirstName like 'A%'");
        display(r4);

    }

    public  void empsFiveHighestSalary() throws SQLException {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r5 = statement.executeQuery("select * from employee1 group by empSalary order by empSalary desc limit 5");
        display(r5);

    }

    public  void empSecondHighestSalary() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r6 = statement.executeQuery("select * from employee1 where empSalary = (select max(empSalary) from employee1 where empSalary<(select max(empSalary) from employee1))");
        display(r6);

    }

    public  void empSalaryLess() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r7 = statement.executeQuery("select * from employee1 where empSalary < (select max(empSalary) from employee1 where empSalary<(select max(empSalary) from employee1))");
        display(r7);

    }

    public  void empDepartment() throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r8 = statement.executeQuery("select empFirstName,name from employee1 e join department1 d where e.empId = d.id");
        while (r8.next()) {
            System.out.println(r8.getString(1) + " " + r8.getString(2));
        }

    }
    public  void empCityY() throws SQLException {

        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r9 = statement.executeQuery("select * from employee1 e join department1 d on (e.empId = d.id) where city = 'Y'");
        display(r9);
    }

    public void empTotalSalary() throws SQLException {

        Statement statement=connection.createStatement();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r10 = statement.executeQuery("select sum(empSalary) from employee1");

        while (r10.next()) {
            System.out.println(r10.getInt(1));
        }
    }
    public void empAvgSalary() throws SQLException {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r11 = statement.executeQuery("select avg(empSalary) from employee1 e join department1 d on e.empId = d.id and city = 'Y'");

        while (r11.next()) {
            System.out.println(r11.getInt(1));
        }
    }

    public void empSalaryDeptWise() throws SQLException {
        Statement statement=connection.createStatement();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        ResultSet r12 = statement.executeQuery("select sum(empSalary) from employee1 e join department1 d on e.empid = d.id group by d.name");

        while (r12.next()) {
            System.out.println(r12.getInt(1));
        }

    }
}
