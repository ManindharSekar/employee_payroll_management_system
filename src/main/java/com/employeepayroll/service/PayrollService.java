package com.employeepayroll.service;

import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.PayrollDTO;

public interface PayrollService {

	public ResponseEntity<String> addPayRoll(PayrollDTO payRoll);

}
