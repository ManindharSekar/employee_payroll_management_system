package com.employeepayroll.service;

import com.employeepayroll.entity.Attendance;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;

import java.time.Month;
import java.util.List;

public interface LeaveService {


    void addLeaves(Attendance att);


    List<Leave> findCurMonthEmpLeave(Employee employee, Month month, int year);
}
