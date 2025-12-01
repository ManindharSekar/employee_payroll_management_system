package com.employeepayroll.service;

import com.employeepayroll.dto.MonthLeaveRuleDTO;
import org.springframework.http.ResponseEntity;

import com.employeepayroll.dto.YearLeaveRuleDTO;

public interface MonthLeaveRuleService {

    public ResponseEntity<String> addMonthLeaveRule(MonthLeaveRuleDTO monthLeaveRuleDTO);

    public MonthLeaveRuleDTO getMonthLeaveRule(Long id);

}
