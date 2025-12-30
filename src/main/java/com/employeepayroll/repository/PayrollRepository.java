package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeepayroll.entity.Payroll;

import java.time.Month;
import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {


    @Query("SELECT p FROM Payroll p WHERE FUNCTION('MONTH', p.date) = :month AND FUNCTION('YEAR', p.date) = :year")
    List<Payroll> findByMonthAndYear(@Param("month") Month month, @Param("year") int year);


}
