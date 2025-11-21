package com.employeepayroll.service;

import com.employeepayroll.repository.LeaveRuleRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.LeaveRule;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.AllowancesRepository;
import com.employeepayroll.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private final LeaveRuleRepository leaveRuleRepository;

	@Autowired
	private AllowancesRepository allowancesRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	EmployeeService(LeaveRuleRepository leaveRuleRepository) {
		this.leaveRuleRepository = leaveRuleRepository;
	}

	public ResponseEntity<Employee> addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		if (employee.getLeaveRule() != null) {
			Long id = employee.getLeaveRule().getId();
			LeaveRule rule = leaveRuleRepository.findById(id)
					.orElseThrow(() -> new RecordNotFoundException("LeaveRule Id Not Found"));
			employee.setLeaveRule(rule);
		}
		if (employee.getAllowances() != null && !employee.getAllowances().isEmpty()) {
			List<Long> ids = employee.getAllowances().stream().map(a -> a.getId()).toList();
			List<Allowances> managedByAllowances = allowancesRepository.findAllById(ids);
			employee.setAllowances(managedByAllowances);
		}
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee Not Found"));
	}

	public List<Allowances> getAllowancesForEmployee(Long empId) {
		Employee emp = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));

		return emp.getAllowances();
	}

	public double getEmpSalary(Long id) {
		// TODO Auto-generated method stub
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		return emp.getSalary();
	}

}
