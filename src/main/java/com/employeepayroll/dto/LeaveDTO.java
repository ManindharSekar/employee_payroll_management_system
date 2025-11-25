package com.employeepayroll.dto;

import java.time.LocalDate;

import com.employeepayroll.entity.Employee;
import lombok.Data;

@Data
public class LeaveDTO {
	
	private Long id;
	
	private String leaveType;

	private LocalDate fromDate;

	private LocalDate toDate;

	private long days;

	private Employee employee;



}
