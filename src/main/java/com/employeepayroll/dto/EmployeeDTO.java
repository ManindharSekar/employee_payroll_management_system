package com.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.YearLeaveRule;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	private Long id;
	
	private String name;

	private String department;

	private double salary;

	private String acc_No;

	private String pf_No;

	private LocalDate joinDate;

	private List<Allowances> allowances;

	private YearLeaveRule leaveRule;
}
