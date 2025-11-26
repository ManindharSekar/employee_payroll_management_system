package com.employeepayroll.service.impl;

import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.service.LeaveService;

import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Autowired
    private  LeaveRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public String  addLeaves(Employee employee, LeaveDTO leaveDTO) {
        Leave map = modelMapper.map(leaveDTO, Leave.class);
        Employee byId = employeeRepository.findById(employee.getId()).orElseThrow(()->new RecordNotFoundException("employee not found"));
        map.setEmployee(byId);
        map.setBalanceLeaves(4);
        map.setNoOfDays(6);
        leaveRepository.save(map);
        return "leave added";

    }
}
