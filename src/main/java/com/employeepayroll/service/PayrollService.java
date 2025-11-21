package com.employeepayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.entity.Payroll;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.repository.PayrollRepository;

@Service
public class PayrollService {


	@Autowired
	private PayrollRepository payrollRepository;
	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LeaveService leaveService;

 

	public ResponseEntity<String> addPayRoll(Payroll payRoll) {
		// TODO Auto-generated method stub
		if (payRoll != null) {
			long days = 0;
			double totalperc = 0;
			double total = 0;
			double deduction = 0;
			double value = 0;
			
			List<Leave> lastOneMonthData = leaveService.getLastOneMonthData(payRoll.getDate());
			Employee employee = payRoll.getEmployee();
			double empSalary = employeeService.getEmpSalary(employee.getId());
		//	List<Leave> employees = leaveRepository.findByEmployee(employee);
			for (Leave emp : lastOneMonthData) {
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
