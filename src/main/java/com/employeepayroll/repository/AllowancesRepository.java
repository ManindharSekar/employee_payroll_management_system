package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeepayroll.entity.Allowances;

@Repository
public interface AllowancesRepository extends JpaRepository<Allowances, Long> {

}
