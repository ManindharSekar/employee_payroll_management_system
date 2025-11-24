package com.employeepayroll.service;

import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.LeaveRuleDTO;
import com.employeepayroll.entity.LeaveRule;

public interface LeaveRuleService {
	
	public ResponseEntity<String> addLeaveRule(LeaveRuleDTO leaveRule);

	public LeaveRuleDTO getLeaveRule(Long id);

}
