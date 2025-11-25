package com.employeepayroll.dto;

import java.time.LocalDate;

import com.employeepayroll.entity.Employee;
import lombok.Data;

@Data
public class PayrollDTO {

	private Long id;

	private LocalDate date;

	private Employee employee;

    //Not In Entity
    private Long days;
    private  double percTotal;
    private double fixedTotal;
    private  double netTotal;
    private double deduction;
    private double leaveDeduction;


}
