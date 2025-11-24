package com.employeepayroll.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.Employee;

public interface EmployeeService {
	
	public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employee);
	
	public EmployeeDTO getEmployee(Long id);

	public List<Allowances> getAllowancesForEmployee(Long empId);

	public double getEmpSalary(Long id);

}
