package com.employeepayroll.controller;

import com.employeepayroll.dto.AttendanceDTO;
import com.employeepayroll.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;


    @PostMapping("/addAttendances")
    public ResponseEntity<String> attendances(@RequestBody List<AttendanceDTO> attendancesDTO){
        return attendanceService.addAttendance(attendancesDTO);
    }

    @GetMapping("/getAttendance/{id}")
    public AttendanceDTO getAttendance(@PathVariable Long id ){
        return attendanceService.getAttendance(id);
    }


}
