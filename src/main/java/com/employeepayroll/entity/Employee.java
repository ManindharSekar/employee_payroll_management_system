package com.employeepayroll.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.type.TrueFalseConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is Required")
	@Size(min = 3, max = 30)
	private String name;

	@NotBlank(message = "Departmet is Required")
	private String department;

	@NotNull(message = "Salary is Required")
	private double salary;

	@NotBlank(message = " Account NO is Required")
	@Size(max = 8,message = "maximum 8 character")
	@Column(unique = true)
	private String acc_No;

	@NotBlank(message = "PF number is Required")
	@Size(max = 6,message = "maximum 6 digit")
	@Pattern(regexp = "^[0-9]+$",message = "PF number must contains numbers only digits")
	@Column(unique = true)
	private String pf_No;

	@NotNull(message = "Join date is required")
	@PastOrPresent
	private LocalDate joinDate;

	@ManyToMany
	@JoinTable(name = "emp_Allowance", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "allowance_id"))
	private List<Allowances> allowances;
	
	@ManyToOne
	private LeaveRule leaveRule;

	public LeaveRule getLeaveRule() {
		return leaveRule;
	}

	public void setLeaveRule(LeaveRule leaveRule) {
		this.leaveRule = leaveRule;
	}

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

}
