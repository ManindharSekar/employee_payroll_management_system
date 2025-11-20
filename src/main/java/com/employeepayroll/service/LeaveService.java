package com.employeepayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.Leave;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepository leaveRepository;

	public ResponseEntity<String> addLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveRepository.save(leave);
		return new ResponseEntity<>("Leave Added",HttpStatus.CREATED);
	}

	public Leave getLeave(Long id) {
		// TODO Auto-generated method stub
		return leaveRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Leave is not found in this id"));
	}
	
	
	

}
