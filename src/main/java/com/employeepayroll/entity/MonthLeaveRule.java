package com.employeepayroll.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthLeaveRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private YearMonth monthYear;

    private int totalDays;

    private int weekEndLeaves;

    private int govLeaves;

    private int workingDays;


    @ManyToOne
    @JoinTable(name = "month_year_rule", joinColumns = @JoinColumn(name = "month_rule_id"), inverseJoinColumns = @JoinColumn(name = "year_rule_id"))
    private YearLeaveRule yearLeaveRule;


}
