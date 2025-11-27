package com.employeepayroll.service.impl;

import com.employeepayroll.dto.AttendanceDTO;
import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.entity.Attendance;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.AttendanceRepository;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.service.AttendanceService;
import com.employeepayroll.service.LeaveService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private LeaveService leaveService;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    @Override
    public ResponseEntity<String> addAttendance(List<AttendanceDTO> attendancesDTO) {
        log.info("getting List of attendances {}", attendancesDTO);

        List<Attendance> attendance = modelMapper.map(attendancesDTO, new org.modelmapper.TypeToken<List<Attendance>>() {
        }.getType());
        attendanceRepository.saveAll(attendance);
        for (Attendance att : attendance) {
            if (!att.isStatus()) {
                leaveService.addLeaves(att.getEmployee().getId());
            }
        }

        return new ResponseEntity<>("List of Attendances added", HttpStatus.CREATED);
    }

    @Override
    public AttendanceDTO getAttendance(Long id) {
        log.info("Fetching Attendance id from database id:{}", id);
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Attendance is not found in thid id:" + id));
        log.debug("Attendance fetched successfully");
        return modelMapper.map(attendance, AttendanceDTO.class);
    }
}
