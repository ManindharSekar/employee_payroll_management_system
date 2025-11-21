package com.employeepayroll.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.EmployeeRepository;
import com.employeepayroll.repository.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseEntity<String> addLeave(Leave leave) {
		// TODO Auto-generated method stub
		LocalDate fromDate = leave.getFromDate();
		LocalDate toDate = leave.getToDate();
		long days = ChronoUnit.DAYS.between(fromDate, toDate) + 1;
		leave.setDays(days);
		leaveRepository.save(leave);
		return new ResponseEntity<>("Leave Added", HttpStatus.CREATED);
	}

	public Leave getLeave(Long id) {
		// TODO Auto-generated method stub
		return leaveRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Leave is not found in this id"));
	}

	public List<Leave> getEmpLeave(Long id) {
		// TODO Auto-generated method stub
		
		Employee empId = employeeRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Employee id Not Found"));
		List<Leave> byEmployee = leaveRepository.findByEmployee(empId);
		return byEmployee;
	}
	
	public List<Leave> getLastOneMonthData(LocalDate inputDate) {
	    LocalDate oneMonthBefore = inputDate.minusMonths(1);
	    return leaveRepository.findBytoDateBetween(oneMonthBefore, inputDate);
	}


}
