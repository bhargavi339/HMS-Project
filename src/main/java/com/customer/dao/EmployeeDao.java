package com.customer.dao;

import java.util.List;

import com.customer.entity.Employees;

public interface EmployeeDao {
	Employees createEmployee(Employees employee);
	 Employees getEmployeeById(String employeeID);
	 List<Employees> getAllEmployees();
	 void updateEmployee(Employees employee);
	 void deleteEmployee(Employees employee);
}
