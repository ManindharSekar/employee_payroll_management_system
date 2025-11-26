package com.employeepayroll.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

}
