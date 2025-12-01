package com.employeepayroll.service.impl;

import com.employeepayroll.entity.MonthLeaveRule;
import com.employeepayroll.entity.YearLeaveRule;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.YearLeaveRuleRepository;
import com.employeepayroll.service.YearLeaveRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class YearLeaveRuleServiceImpl implements YearLeaveRuleService {

    @Autowired
    private YearLeaveRuleRepository yearLeaveRuleRepository;

    @Override
    public void addYearLeaveRule(MonthLeaveRule monthLeaveRule) {
        YearLeaveRule yearLeaveRule = yearLeaveRuleRepository.findByYear(Year.of(monthLeaveRule.getMonthYear().getYear()));

        if(yearLeaveRule==null) {
        YearLeaveRule yearLeave = new YearLeaveRule();
        yearLeave.setYear(Year.of(monthLeaveRule.getMonthYear().getYear()));
        yearLeave.setAnnualLeaveLimit(30);
        yearLeave.setTotalWeekLeaves(monthLeaveRule.getWeekEndLeaves());
        yearLeave.setTotalGovLeaves(monthLeaveRule.getGovLeaves());
        yearLeave.setTotalWorkingDays(monthLeaveRule.getWorkingDays());
        yearLeave.setTotalDays(monthLeaveRule.getWorkingDays()+ monthLeaveRule.getWeekEndLeaves()+ monthLeaveRule.getGovLeaves());
        yearLeaveRuleRepository.save(yearLeave);
    }else{
            Long id = yearLeaveRule.getId();
            if(Year.of(monthLeaveRule.getMonthYear().getYear()).equals(yearLeaveRule.getYear())){
            YearLeaveRule updateLeaveRule = yearLeaveRuleRepository.findById(id).orElseThrow(()->new RecordNotFoundException("yearLeaveRule id is not found"));
            updateLeaveRule.setTotalWeekLeaves(updateLeaveRule.getTotalWeekLeaves()+monthLeaveRule.getWeekEndLeaves());
            updateLeaveRule.setTotalGovLeaves(updateLeaveRule.getTotalGovLeaves()+monthLeaveRule.getGovLeaves());
            updateLeaveRule.setTotalWorkingDays(updateLeaveRule.getTotalWorkingDays()+monthLeaveRule.getWorkingDays());
            updateLeaveRule.setTotalDays(updateLeaveRule.getTotalWorkingDays()+ updateLeaveRule.getTotalWeekLeaves()+ updateLeaveRule.getTotalGovLeaves());
            yearLeaveRuleRepository.save(updateLeaveRule);
        }
    }
    }
}
