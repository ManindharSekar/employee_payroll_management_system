package com.employeepayroll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private  Long id;
	
	@NotBlank(message = "Month is Required")
	private String month;
	
	@NotNull(message = "Gross Salary is Required")
	private double grossSalary;
	
	
	private double deduction;
	
	@NotNull(message = "Net Salary is Required")
	private double net_salary;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getDeduction() {
		return deduction;
	}

	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}

	public double getNet_salary() {
		return net_salary;
	}

	public void setNet_salary(double net_salary) {
		this.net_salary = net_salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne
	private Employee employee;
	

}
