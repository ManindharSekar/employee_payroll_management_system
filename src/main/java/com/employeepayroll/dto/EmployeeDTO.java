package com.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.LeaveRule;

public class EmployeeDTO {
	
	private Long id;
	
	private String name;

	private String department;

	private double salary;

	private String acc_No;

	private String pf_No;

	private LocalDate joinDate;

	private List<Allowances> allowances;

	private LeaveRule leaveRule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAcc_No() {
		return acc_No;
	}

	public void setAcc_No(String acc_No) {
		this.acc_No = acc_No;
	}

	public String getPf_No() {
		return pf_No;
	}

	public void setPf_No(String pf_No) {
		this.pf_No = pf_No;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public List<Allowances> getAllowances() {
		return allowances;
	}

	public void setAllowances(List<Allowances> allowances) {
		this.allowances = allowances;
	}

	public LeaveRule getLeaveRule() {
		return leaveRule;
	}

	public void setLeaveRule(LeaveRule leaveRule) {
		this.leaveRule = leaveRule;
	}

}
