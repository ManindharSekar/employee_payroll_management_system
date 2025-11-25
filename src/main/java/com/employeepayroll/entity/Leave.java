package com.employeepayroll.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_leave")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Leave type is required")
	private String leaveType;

	@NotNull(message = "From Date is Required")
	@Future(message = "From Date must be in Future")
	private LocalDate fromDate;

	@NotNull(message = "To Date Is Required")
	@Future(message = "To Date must be in Future")
	private LocalDate toDate;

	private long days;

	@ManyToOne
	private Employee employee;



}
