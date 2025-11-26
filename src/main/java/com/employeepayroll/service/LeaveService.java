package com.employeepayroll.service;

import com.employeepayroll.entity.Employee;

import com.employeepayroll.dto.LeaveDTO;

public interface LeaveService {


    String addLeaves(Employee employee, LeaveDTO leaveDTO);
}
