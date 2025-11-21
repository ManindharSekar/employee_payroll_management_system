package com.employeepayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.entity.LeaveRule;
import com.employeepayroll.service.LeaveRuleService;

@RestController
@RequestMapping("leaveRule")
public class LeaveRuleController {

	@Autowired
	private LeaveRuleService leaveRuleService;

	@PostMapping("/addLeaveRule")
	public ResponseEntity<String> addLeaveRule(@RequestBody LeaveRule leaveRule) {
		return leaveRuleService.addLeaveRule(leaveRule);
	}

	@GetMapping("/getLeaveRule/{id}")
	public LeaveRule getLeaveRule(@PathVariable Long id) {
		return leaveRuleService.getLeaveRule(id);
	}

}
