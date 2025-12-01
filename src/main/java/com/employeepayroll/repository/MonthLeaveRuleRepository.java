package com.employeepayroll.repository;

import com.employeepayroll.entity.MonthLeaveRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthLeaveRuleRepository extends JpaRepository<MonthLeaveRule,Long> {
}
