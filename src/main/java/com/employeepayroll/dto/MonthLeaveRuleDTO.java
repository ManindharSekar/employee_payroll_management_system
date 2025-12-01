package com.employeepayroll.dto;

import com.employeepayroll.entity.YearLeaveRule;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public class MonthLeaveRuleDTO {

    private Long id;

    private YearMonth monthYear;

    private int totalDays;

    private int weekEndLeaves;

    private int govLeaves;

    private int workingDays;

    private YearLeaveRule yearLeaveRule;
}
