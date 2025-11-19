package com.employeepayroll.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.AllowancesRepository;

@Service
public class AllowenceService {
	
	@Autowired
	private AllowancesRepository allowanceRepository;

	public ResponseEntity<String> addAllowance(Allowances allowances) {
		// TODO Auto-generated method stub
		allowanceRepository.save(allowances);
		return new ResponseEntity<>("Allowences Created",HttpStatus.CREATED);
	}

	public Allowances getAllowance(Long id) {
		// TODO Auto-generated method stub
		return allowanceRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Allowence id="+id+" not found"));
	}

	public ResponseEntity<String> updateAllowance(Long id, Allowances update) {
		// TODO Auto-generated method stub
		Allowances findAllowence = allowanceRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Allowence id="+id+" not found"));
		findAllowence.setAllowanceType(update.getAllowanceType());
		findAllowence.setPay(update.getPay());
		allowanceRepository.save(findAllowence);
		return new ResponseEntity<>("Allowence Updated",HttpStatus.OK);
	}

	public ResponseEntity<String> deleteAllowance(Long id) {
		// TODO Auto-generated method stub
		allowanceRepository.deleteById(id);
		return new ResponseEntity<>("Allowance Deleted",HttpStatus.OK);
	}
	
	

}
