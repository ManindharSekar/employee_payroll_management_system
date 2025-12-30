package com.employeepayroll.repository;

import java.time.Month;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeepayroll.entity.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

    Leave findTopByEmployeeIdOrderByIdDesc(Long employeeId);



    @Query("SELECT l FROM Leave l WHERE FUNCTION('MONTH', l.date) = :month AND FUNCTION('YEAR', l.date) = :year")
    List<Leave> findCurMonthEmpLeave(Long employee, @Param("month") Month month, @Param("year") int year);
}
