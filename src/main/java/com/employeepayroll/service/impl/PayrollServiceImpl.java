package com.employeepayroll.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.dto.PayrollDTO;
import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.entity.Payroll;
import com.employeepayroll.repository.PayrollRepository;
import com.employeepayroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService{

	@Autowired
	private PayrollRepository payrollRepository;

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private LeaveServiceImpl leaveService;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<String> addPayRoll(PayrollDTO payRollDTO) {
		// TODO Auto-generated method stub
		Payroll payRoll = modelMapper.map(payRollDTO, Payroll.class);
		if (payRoll != null) {
			long days = 0;
			double totalperc = 0;
			double total = 0;
			double deduction = 0;
			double value = 0;

			List<LeaveDTO> lastOneMonthData = leaveService.getLastOneMonthData(payRoll.getDate());
			Employee employee = payRoll.getEmployee();
			double empSalary = employeeService.getEmpSalary(employee.getId());
			for (LeaveDTO emp : lastOneMonthData) {
				days += emp.getDays();
			}
			double leaveDeduction = days * 200;
			List<Allowances> allowances = employeeService.getAllowancesForEmployee(employee.getId());
			for (Allowances allo : allowances) {
				if (allo.getAmountType().equalsIgnoreCase("PERCENTAGE")) {
					totalperc = totalperc + empSalary / allo.getValue();
				} else if (allo.getAmountType().equalsIgnoreCase("FIXED")) {
					value = value + allo.getValue();

				}
			}
			total = empSalary - value - totalperc - leaveDeduction;
			deduction = value + totalperc + leaveDeduction;
			payRoll.setGrossSalary(empSalary);
			payRoll.setDeduction(deduction);
			payRoll.setNet_salary(total);

		}
		payrollRepository.save(payRoll);
		return new ResponseEntity<>("PayRoll Created", HttpStatus.CREATED);
	}

}
