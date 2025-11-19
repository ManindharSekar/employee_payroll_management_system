package com.employeepayroll.controller;

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
import com.employeepayroll.service.AllowenceService;

@RestController
@RequestMapping("allowance")
public class AllowanceController {
	
	@Autowired
	private AllowenceService allowanceService;
	
	@PostMapping("/addAllowance")
	public ResponseEntity<String> addAllowence(@RequestBody Allowances allowances){
		return allowanceService.addAllowance(allowances);
	}
	
	@GetMapping("/getAllowance/{id}")
	public Allowances getAllowance(@PathVariable Long id) {
		return allowanceService.getAllowance(id);
	}
	
	@PutMapping("updateAllowance/{id}")
	public ResponseEntity<String> updateAllowance(@PathVariable Long id,@RequestBody Allowances update) {
		//TODO: process PUT request
		
		return allowanceService.updateAllowance(id,update);
	}
	
	@DeleteMapping("deleteAllowance/{id}")
	public ResponseEntity<String> deleteAllowance(@PathVariable Long id){
		return allowanceService.deleteAllowance(id);
	}

}
