package com.company;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeController {

    public static void main(String[] args) throws Exception {

           Scanner sc= new Scanner (System.in);

           CreateTables table= new CreateTables();
           EmployeeUtility emp=new EmployeeUtility();
           DepartmentUtility dept= new DepartmentUtility();

           while(true){

               System.out.println("1. Create Employee and Department Table");
               System.out.println("2. Insert Record into Employee Table");
               System.out.println("3. Insert Record into Department Table");
               System.out.println("4. List All the Employee with following details - id,name(firstName+lastName),email,designation");
               System.out.println("5. List All the Employee with designation as Software engineer and QA engineer");
               System.out.println("6. List All the Employee with their reporting manager");
               System.out.println("7. List All the Employee whose name start with Alphabet 'A' ");
               System.out.println("8. List Top 5 Employee with highest Salary ");
               System.out.println("9. Find the employee with 2nd highest salary in the company ");
               System.out.println("10. Find All the employee whose salary is less than employee with 2nd highest salary");
               System.out.println("11. List All the Employee with their department name ");
               System.out.println("12. Get List of the employee who were working on Y city ");
               System.out.println("13. Find Total Salary given to Employee in the company");
               System.out.println("14. Find Average Salary given to Employee in city Y");
               System.out.println("15. Find Total Salary given to the Employee department wise");
               System.out.println("16. Exit");

               System.out.println("\n Enter Your Choice:");

               //int choice=Integer.parseInt(br.readLine());
               int choice=sc.nextInt();

               if(choice==1){
                   table.createTable();
               }else if(choice==2){
                   emp.insertEmployeeRecord();
               }
               else if(choice==3){
                   dept.insertDepartmentRecord();
               }
               else if(choice==4){
                   emp.empDetails();
               }
               else if(choice==5){
                   emp.empDesignation();
               }
               else if(choice==6){
                   emp.empReportTo();
               }
               else if(choice==7){
                   emp.empNameStartWithA();
               }
               else if(choice==8){
                   emp.empsFiveHighestSalary();
               }
               else if(choice==9){
                   emp.empSecondHighestSalary();
               }
               else if(choice==10){
                   emp.empSalaryLess();
               }
               else if(choice==11){
                   emp.empDepartment();
               }
               else if(choice==12){
                   emp.empCityY();
               }
               else if(choice==13){
                   emp.empTotalSalary();
               }
               else if(choice==14){
                   emp.empAvgSalary();
               }
               else if(choice==15){

                   emp.empSalaryDeptWise();
               }
               else {
                   break;
               }

           }

    }
}
