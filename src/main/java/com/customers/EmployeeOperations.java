package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.EmployeeDao;
import com.customer.daoImpl.EmployeeDaoImpl;
import com.customer.entity.Employees;

public class EmployeeOperations {
	static Scanner sc=new Scanner(System.in);
	static EmployeeDao employeeDao=new EmployeeDaoImpl();
	static void employeeDetails() {
		 System.out.println("Press 1: Add Employee details");
		 System.out.println("Press 2: All Employees details");
		 System.out.println("Press 3: Update Employee details");
		 System.out.println("Press 4: Delete Employee details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Employees employee=employeeInputs();
			Employees savedEmployee= employeeDao.createEmployee(employee);
			System.out.println("Employee "+savedEmployee+" added successfully");
			break;
		 case 2:
	         displayAllEmployees();
	         break;
	     case 3:
	         updateEmployee();
	         break;
	     case 4:
	    	 deleteEmployee();
	     default:
	         System.out.println("Invalid choice");	
		 }
	 }
	 static Employees employeeInputs() {
		 sc.nextLine();
		 System.out.println("Enter EmployeeID");
		 String employeeID=sc.nextLine();
		 
		 System.out.println("Enter Employee Name ");
		 String employeeName=sc.nextLine();
		 
		 System.out.println("Enter Job Description of Employee");
		 String jobDescription=sc.nextLine();
		 
		 System.out.println("Enter Mobile Number of Employee ");
		 String mobileNumber=sc.nextLine();
		 
		 System.out.println("Enter address of the employee ");
		 String adress=sc.nextLine();
		 
		 System.out.println("Enter age of the employee");
		 int age=sc.nextInt();
		 
		 System.out.println("Enter salary of employee");
		 double salary=sc.nextDouble();
		  
		 return new Employees(employeeID,employeeName,jobDescription,mobileNumber,adress,age,salary);
	 }
	 static void displayAllEmployees() {
		    List<Employees> employees = employeeDao.getAllEmployees();
		    if (employees.isEmpty()) {
		        System.out.println("No Employees found.");
		    } else {
		        System.out.println("All Employees:");
		        for (Employees employee : employees) {
		            System.out.println("Employee ID: " + employee.getEmployeeID());
		            System.out.println("Employee Name: " + employee.getEmployeeName());
		            System.out.println("Job Description: " + employee.getJobDescription());
		            System.out.println("Age: " + employee.getAge());
		            System.out.println("Mobile Number: " + employee.getMobileNumber());
		            System.out.println("Address: " + employee.getAdress());
		            System.out.println("Salary: " + employee.getSalary());
		            System.out.println("------------------------");
		        }
		    }
		}
	   static void updateEmployee() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Employee ID to update:");
		    String employeeIDToUpdate = sc.nextLine();

		    // Check if the hotel exists
		    Employees existingEmployee = employeeDao.getEmployeeById(employeeIDToUpdate);
		    if (existingEmployee == null) {
		        System.out.println("Employee with ID " + employeeIDToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Name of the Employee(Leave blank to keep current: " + existingEmployee.getEmployeeName() + ")");
		    String employeeName = sc.nextLine();
		    if (!employeeName.isEmpty()) {
		        existingEmployee.setEmployeeName(employeeName);
		    }

		    System.out.println("Enter new Job Description (Leave blank to keep current: " + existingEmployee.getJobDescription() + ")");
		    String jobDescription = sc.nextLine();
		    if (!jobDescription.isEmpty()) {
		        existingEmployee.setJobDescription(jobDescription);
		    }
		    
		    System.out.println("Enter new age (leave blank to keep current): ");
		    String newAgeStr = sc.nextLine();
		    if (!newAgeStr.isBlank()) {
		        try {
		            int newAge = Integer.parseInt(newAgeStr);
		            existingEmployee.setAge(newAge);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid age format. Age not updated.");
		        }
		    }
		    
		    
		    System.out.println("Enter new mobile Number (Leave blank to keep current: " + existingEmployee.getMobileNumber() + ")");
		    String mobileNumber = sc.nextLine();
		    if (!mobileNumber.isEmpty()) {
		        existingEmployee.setMobileNumber(mobileNumber);
		    }
		    
		    System.out.println("Enter new salary (leave blank to keep current): ");
		    String newSalaryStr = sc.nextLine();
		    if (!newSalaryStr.isBlank()) {
		        try {
		            double newSalary = Double.parseDouble(newSalaryStr);
		            existingEmployee.setSalary(newSalary);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. Salary not updated.");
		        }
		    }
		 
		    employeeDao.updateEmployee(existingEmployee);
		    System.out.println("Employee with ID " + employeeIDToUpdate + " updated successfully.");
		}
	   static void deleteEmployee() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the EmployeeID of the Employee to delete: ");
		    String employeeID = sc.nextLine();

		    Employees existingEmployee = employeeDao.getEmployeeById(employeeID);

		    if (existingEmployee == null) {
		        System.out.println("Employee with ID " + employeeID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Employee?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	employeeDao.deleteEmployee(existingEmployee);
		        System.out.println("Employee deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}
