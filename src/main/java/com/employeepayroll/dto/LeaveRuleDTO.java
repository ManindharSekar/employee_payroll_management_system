package com.employeepayroll.dto;

import lombok.Data;

import java.time.Year;

@Data
public class LeaveRuleDTO {
	
	private Long id;
	
	private Year year;

	private int totalDays;

	private int totalGovLeaves;

	private int totalWeekLeaves;

	private int totalWorkingDays;

	private int annualLeaveLimit;


}
