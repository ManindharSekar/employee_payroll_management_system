package com.employeepayroll.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.entity.Leave;

public interface LeaveService {

	public ResponseEntity<String> addLeave(LeaveDTO leave);

	public LeaveDTO getLeave(Long id);

	public List<LeaveDTO> getEmpLeave(Long id);

	public List<LeaveDTO> getLastOneMonthData(LocalDate inputDate);

}
