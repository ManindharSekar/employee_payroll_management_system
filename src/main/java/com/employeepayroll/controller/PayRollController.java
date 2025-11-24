package com.employeepayroll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.dto.PayrollDTO;
import com.employeepayroll.entity.Payroll;
import com.employeepayroll.service.impl.PayrollServiceImpl;

@RestController
@RequestMapping("/payRoll")
public class PayRollController {

	@Autowired
	private PayrollServiceImpl payrollService;
	
	private static final Logger log=LoggerFactory.getLogger(PayRollController.class);

	@PostMapping("/addPayRoll")
	public ResponseEntity<String> addPayRoll(@RequestBody PayrollDTO payRollDTO) {
		log.info("Request received for creating parRoll {}",payRollDTO);
		return payrollService.addPayRoll(payRollDTO);

	}

}
