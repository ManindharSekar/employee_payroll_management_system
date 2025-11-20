package com.employeepayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

		return employeeService.addEmployee(employee);
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmployee(id);

	}

}
