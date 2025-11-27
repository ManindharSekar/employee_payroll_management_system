package com.employeepayroll.service.impl;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.EmployeeRepository;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.service.LeaveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Autowired
    private  LeaveRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addLeaves(Long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Employee not found"));
        Leave leave = new Leave();
        leave.setEmployee(emp);
        leave.setBalanceLeaves(29);
        leave.setNoOfDays(1);
        leaveRepository.save(leave);
    }
}
