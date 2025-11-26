package com.employeepayroll.dto;

import com.employeepayroll.entity.YearLeaveRule;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MonthLeaveRuleDTO {

    private Long id;

    private LocalDate Month;

    private int totalDays;

    private int weekEndLeaves;

    private int govLeaves;

    private int workingDays;

    private YearLeaveRule yearLeaveRule;
}
