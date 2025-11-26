package com.employeepayroll.dto;

import java.time.LocalDate;

import com.employeepayroll.entity.Employee;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class LeaveDTO {

    private Long id;

    private int noOfDays;

    private int balanceLeaves;

    private Employee employee;


}
