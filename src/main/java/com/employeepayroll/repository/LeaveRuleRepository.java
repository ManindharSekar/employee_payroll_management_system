package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.YearLeaveRule;

public interface LeaveRuleRepository extends JpaRepository<YearLeaveRule,Long> {

}
