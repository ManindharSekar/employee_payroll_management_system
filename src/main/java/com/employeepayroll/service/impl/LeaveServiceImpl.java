package com.employeepayroll.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.EmployeeRepository;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<String> addLeave(LeaveDTO leaveDTO) {
		// TODO Auto-generated method stub
		Leave leave = modelMapper.map(leaveDTO, Leave.class);
		LocalDate fromDate = leave.getFromDate();
		LocalDate toDate = leave.getToDate();
		long days = ChronoUnit.DAYS.between(fromDate, toDate) + 1;
		leave.setDays(days);
		leaveRepository.save(leave);
		return new ResponseEntity<>("Leave Added", HttpStatus.CREATED);
	}

	public LeaveDTO getLeave(Long id) {
		// TODO Auto-generated method stub
		Leave leave= leaveRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Leave is not found in this id"));
		return modelMapper.map(leave, LeaveDTO.class);
	}

	public List<LeaveDTO> getEmpLeave(Long id) {
		// TODO Auto-generated method stub

		Employee empId = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee id Not Found"));
		List<Leave> byEmployee = leaveRepository.findByEmployee(empId);
		return (List<LeaveDTO>) modelMapper.map(byEmployee, LeaveDTO.class);
	}

	public List<LeaveDTO> getLastOneMonthData(LocalDate inputDate) {
		LocalDate oneMonthBefore = inputDate.minusMonths(1);
		List<Leave> oneMonthBeforeData = leaveRepository.findBytoDateBetween(oneMonthBefore, inputDate);
		return (List<LeaveDTO>) modelMapper.map(oneMonthBeforeData, LeaveDTO.class);
	}

}
