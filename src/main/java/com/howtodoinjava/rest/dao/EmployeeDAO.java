package com.howtodoinjava.rest.dao;

import javax.annotation.ManagedBean;

import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@ManagedBean
public class EmployeeDAO {
	
	private static Employees list = new Employees();

	static
	{
		list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
	}
	public Employees getAllEmployee() 
	{
		
		return list;
	}

	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
		
	}
	
}
