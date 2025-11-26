package com.employeepayroll.service;

import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.YearLeaveRuleDTO;

public interface LeaveRuleService {
	
	public ResponseEntity<String> addLeaveRule(YearLeaveRuleDTO leaveRule);

	public YearLeaveRuleDTO getLeaveRule(Long id);

}
