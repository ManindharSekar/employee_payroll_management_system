package com.employeepayroll.service.impl;


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
import com.employeepayroll.repository.LeaveRuleRepository;
import com.employeepayroll.service.LeaveRuleService;

@Service
public class LeaveRuleServiceImpl implements LeaveRuleService {


    @Autowired
    private LeaveRuleRepository leaveRuleRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(LeaveRuleServiceImpl.class);


    public ResponseEntity<String> addLeaveRule(YearLeaveRuleDTO leaveRuleDTO) {
        // TODO Auto-generated method stub
        YearLeaveRule leaveRule = modelMapper.map(leaveRuleDTO, YearLeaveRule.class);
        leaveRuleRepository.save(leaveRule);
        return new ResponseEntity<>("LeaveRule Created", HttpStatus.CREATED);
    }

    public YearLeaveRuleDTO getLeaveRule(Long id) {
        // TODO Auto-generated method stub
        log.info("Fetching Student from database. {}" + id);
        YearLeaveRule leaveRule = leaveRuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("LeaveRule id=" + id + " not found"));
        return modelMapper.map(leaveRule, YearLeaveRuleDTO.class);
    }


}
