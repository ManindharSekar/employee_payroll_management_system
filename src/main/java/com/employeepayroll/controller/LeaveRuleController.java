package com.employeepayroll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.dto.YearLeaveRuleDTO;
import com.employeepayroll.service.impl.LeaveRuleServiceImpl;

@RestController
@RequestMapping("leaveRule")
public class LeaveRuleController {

	@Autowired
	private LeaveRuleServiceImpl leaveRuleService;
	
	private static final Logger log=LoggerFactory.getLogger(LeaveRuleController.class);

	@PostMapping("/addLeaveRule")
	public ResponseEntity<String> addLeaveRule(@RequestBody YearLeaveRuleDTO leaveRuleDTO) {
		log.info("Request received for create LeaveRule {}",leaveRuleDTO);
		return leaveRuleService.addLeaveRule(leaveRuleDTO);
	}

	@GetMapping("/getLeaveRule/{id}")
	public YearLeaveRuleDTO getLeaveRule(@PathVariable Long id) {
		log.info("Request received form leaveRule id:{}"+id);
		return leaveRuleService.getLeaveRule(id);
	}

}
