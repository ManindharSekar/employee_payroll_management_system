package com.employeepayroll.dto;

import java.time.Year;

public class LeaveRuleDTO {
	
	private Long id;
	
	private Year year;

	private int totalDays;

	private int totalGovLeaves;

	private int totalWeekLeaves;

	private int totalWorkingDays;

	private int annualLeaveLimit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalGovLeaves() {
		return totalGovLeaves;
	}

	public void setTotalGovLeaves(int totalGovLeaves) {
		this.totalGovLeaves = totalGovLeaves;
	}

	public int getTotalWeekLeaves() {
		return totalWeekLeaves;
	}

	public void setTotalWeekLeaves(int totalWeekLeaves) {
		this.totalWeekLeaves = totalWeekLeaves;
	}

	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}

	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}

	public int getAnnualLeaveLimit() {
		return annualLeaveLimit;
	}

	public void setAnnualLeaveLimit(int annualLeaveLimit) {
		this.annualLeaveLimit = annualLeaveLimit;
	}

}
