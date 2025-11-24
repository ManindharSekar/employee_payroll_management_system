package com.employeepayroll.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.entity.Leave;
import com.employeepayroll.service.LeaveService;

@RestController
@RequestMapping("leave")
public class LeaveController {

	private final LeaveService leaveService;

	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
	
	private static final Logger log=LoggerFactory.getLogger(LeaveController.class);

	@PostMapping("/addLeave")
	public ResponseEntity<String> addLeave(@RequestBody Leave leave) {
		log.info("Request received for creation Leave: {}",leave);
		return leaveService.addLeave(leave);

	}

	@GetMapping("/getLeave/{id}")
	public Leave getLeave(@PathVariable Long id) {
		return leaveService.getLeave(id);
	}

	@GetMapping("getEmpLeave/{id}")
	public List<Leave> getEmpLeave(@PathVariable Long id) {
		return leaveService.getEmpLeave(id);
	}

	@GetMapping("/last-month")
	public List<Leave> getLastMonthData(@RequestParam LocalDate date) {
		return leaveService.getLastOneMonthData(date);
	}

}
