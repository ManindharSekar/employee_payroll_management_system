package com.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeepayroll.entity.Allowances;
import com.employeepayroll.entity.Employee;

@Repository
public interface AllowancesRepository extends JpaRepository<Allowances, Long> {

}
