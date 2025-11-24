package com.employeepayroll.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.employeepayroll.repository.LeaveRuleRepository;

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

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public ResponseEntity<Employee> addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		if (employee.getLeaveRule() != null) {
			Long id = employee.getLeaveRule().getId();
			logger.info("Fetching LeaveRule id: {}", id);
			LeaveRule rule = leaveRuleRepository.findById(id)
					.orElseThrow(() -> new RecordNotFoundException("LeaveRule Id Not Found"));
			logger.debug("Found LeaveRule {}"+rule);
			employee.setLeaveRule(rule);
		}
		if (employee.getAllowances() != null && !employee.getAllowances().isEmpty()) {
			List<Long> ids = employee.getAllowances().stream().map(a -> a.getId()).toList();
			logger.info("Fetching Allowances id's");
			List<Allowances> managedByAllowances = allowancesRepository.findAllById(ids);
			logger.info("Found Allowances");
			employee.setAllowances(managedByAllowances);
		}
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		logger.info("Fetching Employee with id: {}",id);
		return employeeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee Not Found"));
	}

	public List<Allowances> getAllowancesForEmployee(Long empId) {
		logger.info("Fetching Allowances for Employee from database {}",empId);
		Employee emp = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
		logger.debug("Allowances for Employee fetched successfully");
		return emp.getAllowances();
	}

	public double getEmpSalary(Long id) {
		// TODO Auto-generated method stub
		logger.info("Fetching Employee salary with id: {}",id);
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		logger.debug("Employee salary fetched successfully");
		return emp.getSalary();
	}

}
