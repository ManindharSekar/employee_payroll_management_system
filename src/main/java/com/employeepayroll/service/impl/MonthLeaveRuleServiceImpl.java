package com.employeepayroll.service.impl;


import com.employeepayroll.dto.MonthLeaveRuleDTO;
import com.employeepayroll.entity.MonthLeaveRule;
import com.employeepayroll.repository.MonthLeaveRuleRepository;
import com.employeepayroll.service.YearLeaveRuleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.YearLeaveRuleDTO;
import com.employeepayroll.entity.YearLeaveRule;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.YearLeaveRuleRepository;
import com.employeepayroll.service.MonthLeaveRuleService;

import java.util.Optional;

@Service
public class MonthLeaveRuleServiceImpl implements MonthLeaveRuleService {


    @Autowired
    private YearLeaveRuleRepository yearLeaveRuleRepository;

    @Autowired
    private MonthLeaveRuleRepository monthLeaveRuleRepository;

    @Autowired
    private YearLeaveRuleService yearLeaveRuleService;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(MonthLeaveRuleServiceImpl.class);


    public ResponseEntity<String> addMonthLeaveRule(MonthLeaveRuleDTO monthLeaveRuleDTO) {
        // TODO Auto-generated method stub
        MonthLeaveRule monthLeaveRule = modelMapper.map(monthLeaveRuleDTO, MonthLeaveRule.class);
        monthLeaveRuleRepository.save(monthLeaveRule);
            yearLeaveRuleService.addYearLeaveRule(monthLeaveRule);

        return new ResponseEntity<>("LeaveRule Created", HttpStatus.CREATED);
    }

    public MonthLeaveRuleDTO getMonthLeaveRule(Long id) {
        // TODO Auto-generated method stub
        log.info("Fetching Month Leave Rule from database. {}" + id);
        MonthLeaveRule monthLeaveRule = monthLeaveRuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("MonthLeaveRule id=" + id + " not found"));
        return modelMapper.map(monthLeaveRule, MonthLeaveRuleDTO.class);
    }


}
