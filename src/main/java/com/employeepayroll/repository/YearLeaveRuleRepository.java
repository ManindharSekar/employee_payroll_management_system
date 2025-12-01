package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.YearLeaveRule;
import org.springframework.stereotype.Repository;

import java.time.Year;

@Repository
public interface YearLeaveRuleRepository extends JpaRepository<YearLeaveRule,Long> {

    YearLeaveRule findByYear(Year year);
}
