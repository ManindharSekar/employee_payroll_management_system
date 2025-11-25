package com.employeepayroll.entity;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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



}
