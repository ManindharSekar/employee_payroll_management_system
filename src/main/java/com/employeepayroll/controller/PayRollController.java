package com.employeepayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.entity.Payroll;
import com.employeepayroll.service.PayrollService;

@RestController
@RequestMapping("/payRoll")
public class PayRollController {
	
	@Autowired
	private PayrollService payrollService;
	
	@PostMapping("/addPayRoll")
	public ResponseEntity<String> addPayRoll(@RequestBody Payroll payRoll){
		return payrollService.addPayRoll(payRoll);
		
	}

}
