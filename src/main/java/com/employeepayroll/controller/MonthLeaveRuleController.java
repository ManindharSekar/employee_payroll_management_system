package com.employeepayroll.controller;

import com.employeepayroll.dto.MonthLeaveRuleDTO;
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
import com.employeepayroll.service.impl.MonthLeaveRuleServiceImpl;

@RestController
@RequestMapping("monthLeaveRule")
public class MonthLeaveRuleController {

	@Autowired
	private MonthLeaveRuleServiceImpl monthLeaveRuleService;
	
	private static final Logger log=LoggerFactory.getLogger(MonthLeaveRuleController.class);

	@PostMapping("/addMonthLeaveRule")
	public ResponseEntity<String> addLeaveRule(@RequestBody MonthLeaveRuleDTO monthLeaveRuleDTO) {
		log.info("Request received for create MonthLeaveRule {}",monthLeaveRuleDTO);
		return monthLeaveRuleService.addMonthLeaveRule(monthLeaveRuleDTO);
	}

	@GetMapping("/getMonthLeaveRule/{id}")
	public MonthLeaveRuleDTO getLeaveRule(@PathVariable Long id) {
		log.info("Request received form MonthLeaveRule id:{}"+id);
		return monthLeaveRuleService.getMonthLeaveRule(id);
	}

}
