package com.employeepayroll.dto;

import com.employeepayroll.entity.Employee;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO {

    private Long id;

    private LocalDate date;

    private boolean status;

    private Employee employee;
}
