package com.employeepayroll.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.LeaveRule;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.LeaveRuleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaveRuleService {

	@Autowired
	private LeaveRuleRepository leaveRuleRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(LeaveRuleService.class);

	public ResponseEntity<String> addLeaveRule(LeaveRule leaveRule) {
		// TODO Auto-generated method stub
		leaveRuleRepository.save(leaveRule);
		return new ResponseEntity<>("LeaveRule Created", HttpStatus.CREATED);
	}

	public LeaveRule getLeaveRule(Long id) {
		// TODO Auto-generated method stub
		logger.info("Fetching Student from database. {}"+id);
		return leaveRuleRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("LeaveRule id=" + id + " not found"));
	}

}
