package com.employeepayroll.service;

import com.employeepayroll.dto.AttendanceDTO;
import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.entity.Attendance;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AttendanceService {


    ResponseEntity<String> addAttendance(List<AttendanceDTO> attendancesDTO);

    AttendanceDTO getAttendance(Long id);

    List<AttendanceDTO> getLastOneMonthData(@NotNull(message = "Date is Required") LocalDate date);
}
