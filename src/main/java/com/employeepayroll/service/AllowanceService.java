package com.employeepayroll.service;

import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.AllowancesDTO;

public interface AllowanceService {
	
	public ResponseEntity<String> addAllowance(AllowancesDTO allowances);

	public AllowancesDTO getAllowance(Long id);

	public ResponseEntity<String> updateAllowance(Long id, AllowancesDTO update); 

	public ResponseEntity<String> deleteAllowance(Long id);

}
