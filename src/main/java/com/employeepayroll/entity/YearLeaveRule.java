package com.employeepayroll.entity;

import java.time.Year;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YearLeaveRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Year is Required")
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

    @OneToMany
    private List<MonthLeaveRule> monthLeaveRules;




}
