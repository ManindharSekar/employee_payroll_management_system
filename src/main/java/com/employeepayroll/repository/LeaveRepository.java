package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeepayroll.entity.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

}
