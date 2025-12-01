package com.employeepayroll.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.YearLeaveRule;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.AllowancesRepository;
import com.employeepayroll.repository.EmployeeRepository;
import com.employeepayroll.repository.YearLeaveRuleRepository;
import com.employeepayroll.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final YearLeaveRuleRepository leaveRuleRepository;

	@Autowired
	private AllowancesRepository allowancesRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	EmployeeServiceImpl(YearLeaveRuleRepository leaveRuleRepository) {
		this.leaveRuleRepository = leaveRuleRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public ResponseEntity<EmployeeDTO> addEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		Employee emp = modelMapper.map(employee, Employee.class);
		
		if (emp.getLeaveRule() != null) {
			Long id = emp.getLeaveRule().getId();
			logger.info("Fetching LeaveRule id: {}", id);
			YearLeaveRule rule = leaveRuleRepository.findById(id)
					.orElseThrow(() -> new RecordNotFoundException("LeaveRule Id Not Found"));
			logger.debug("Found LeaveRule {}",rule);
			emp.setLeaveRule(rule);
		}
		if (emp.getAllowances() != null && !emp.getAllowances().isEmpty()) {
			List<Long> ids = employee.getAllowances().stream().map(a -> a.getId()).toList();
			logger.info("Fetching Allowances id's");
			List<Allowances> managedByAllowances = allowancesRepository.findAllById(ids);
			logger.info("Found Allowances");
			emp.setAllowances(managedByAllowances);
		}
		
		employeeRepository.save(emp);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public EmployeeDTO getEmployee(Long id) {
		// TODO Auto-generated method stub
		logger.info("Fetching Employee with id: {}",id);
				Employee emp=employeeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee Not Found"));
				return modelMapper.map(emp, EmployeeDTO.class);
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
