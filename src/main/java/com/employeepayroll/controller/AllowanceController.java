package com.employeepayroll.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.service.AllowanceService;

@RestController
@RequestMapping("allowance")
public class AllowanceController {

	@Autowired
	private AllowanceService allowanceService;
	
	private static final Logger log=LoggerFactory.getLogger(AllowanceController.class);

	@PostMapping("/addAllowance")
	public ResponseEntity<String> addAllowence(@RequestBody Allowances allowances) {
		log.info("Post Request received to create allowances: {}",allowances);
		return allowanceService.addAllowance(allowances);
	}

	@GetMapping("/getAllowance/{id}")
	public Allowances getAllowance(@PathVariable Long id) {
		return allowanceService.getAllowance(id);
	}

	@PutMapping("updateAllowance/{id}")
	public ResponseEntity<String> updateAllowance(@PathVariable Long id, @RequestBody Allowances update) {
		return allowanceService.updateAllowance(id, update);
	}

	@DeleteMapping("deleteAllowance/{id}")
	public ResponseEntity<String> deleteAllowance(@PathVariable Long id) {
		return allowanceService.deleteAllowance(id);
	}

}
