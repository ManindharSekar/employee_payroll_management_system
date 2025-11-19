package com.employeepayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	public ResponseEntity<Employee> addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


	public Employee  getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Employee Not Found"));
	}

}
