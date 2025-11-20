package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.LeaveRule;

public interface LeaveRuleRepository extends JpaRepository<LeaveRule,Long> {

}
