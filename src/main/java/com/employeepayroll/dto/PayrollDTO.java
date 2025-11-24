package com.employeepayroll.dto;

import java.time.LocalDate;

import com.employeepayroll.entity.Employee;

public class PayrollDTO {

	private Long id;

	private LocalDate date;

	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
