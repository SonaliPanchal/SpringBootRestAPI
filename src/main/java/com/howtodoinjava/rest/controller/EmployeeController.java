package com.howtodoinjava.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.howtodoinjava.rest.dao.EmployeeDAO;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {

	@Autowired 
	private EmployeeDAO employeedao;

	@RequestMapping(path="/list",produces="application/json")
	public  Employees getEmployess() {

		return employeedao.getAllEmployee();

	}
	
	@PostMapping(path="/add",produces="application/json",consumes="application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
	{
		Integer id = employeedao.getAllEmployee().getEmployeeList().size()+1;
		employee.setId(id);
		employeedao.addEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(employee.getId())
				.toUri();
		System.out.println("URiLocation "+location);

		return ResponseEntity.created(location).build();

	}
	
	
}
