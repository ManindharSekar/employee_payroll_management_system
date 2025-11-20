package com.employeepayroll.entity;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class LeaveRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Year is Required")
	@Column(unique = true)
	private Year year;

	@NotNull(message = "totalDays is Required")
	private int totalDays;

	@NotNull(message = "totalGovLeaves is Required")
	private int totalGovLeaves;

	@NotNull(message = "totalWeekLeaves is Required")
	private int totalWeekLeaves;

	@NotNull(message = "totalWorkingDays is Required")
	private int totalWorkingDays;

	@NotNull(message = "annualLeaveLimit is Required")
	private int annualLeaveLimit;

	public int getAnnualLeaveLimit() {
		return annualLeaveLimit;
	}

	public void setAnnualLeaveLimit(int annualLeaveLimit) {
		this.annualLeaveLimit = annualLeaveLimit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

}
