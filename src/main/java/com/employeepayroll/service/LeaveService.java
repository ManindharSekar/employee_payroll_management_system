package com.employeepayroll.service;

import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.entity.Attendance;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public interface LeaveService {


    void addLeaves(Attendance att);

    List<LeaveDTO> getLastOneMonthData(@NotNull(message = "Date is Required") LocalDate date);
}
