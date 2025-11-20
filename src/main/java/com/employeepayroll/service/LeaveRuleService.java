package com.employeepayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.LeaveRule;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.LeaveRuleRepository;

@Service
public class LeaveRuleService {
	
	@Autowired
	private LeaveRuleRepository leaveRuleRepository;

	public ResponseEntity<String> addLeaveRule(LeaveRule leaveRule) {
		// TODO Auto-generated method stub
		leaveRuleRepository.save(leaveRule);
		return new ResponseEntity<>("LeaveRule Created",HttpStatus.CREATED);
	}

	public LeaveRule getLeaveRule(Long id) {
		// TODO Auto-generated method stub
		return leaveRuleRepository.findById(id).orElseThrow(()->new RecordNotFoundException("LeaveRule id="+id+" not found"));
	}

}
