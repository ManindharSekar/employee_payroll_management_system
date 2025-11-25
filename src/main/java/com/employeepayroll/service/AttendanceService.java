package com.employeepayroll.service;

import com.employeepayroll.dto.AttendanceDTO;
import com.employeepayroll.entity.Attendance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {


    ResponseEntity<String> addAttendance(List<AttendanceDTO> attendancesDTO);

    AttendanceDTO getAttendance(Long id);
}
