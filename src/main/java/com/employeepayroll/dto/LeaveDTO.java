package com.employeepayroll.dto;

import java.time.LocalDate;

import com.employeepayroll.entity.Employee;

public class LeaveDTO {
	
	private Long id;
	
	private String leaveType;

	private LocalDate fromDate;

	private LocalDate toDate;

	private long days;

	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
