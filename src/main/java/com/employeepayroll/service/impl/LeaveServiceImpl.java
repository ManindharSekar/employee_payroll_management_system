package com.employeepayroll.service.impl;

import com.employeepayroll.entity.Attendance;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.Leave;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.EmployeeRepository;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.repository.LeaveRuleRepository;
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
    private LeaveRuleRepository leaveRuleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addLeaves(Attendance att){
        Employee emp = employeeRepository.findById(att.getEmployee().getId()).orElseThrow(()->new RecordNotFoundException("Employee not found"));
        Leave createLeave = findOrCreateLeave(emp,att);

        leaveRepository.save(createLeave);
    }

    public Leave findOrCreateLeave(Employee emp, Attendance att){
        Leave latest = leaveRepository.findTopByEmployeeIdOrderByIdDesc(emp.getId());
        Leave leave = new Leave();
        if(latest==null){
           leave.setEmployee(emp);
           int annualLeaveLimit = emp.getLeaveRule().getAnnualLeaveLimit();
           leave.setBalanceLeaves(annualLeaveLimit-1);
           leave.setNoOfDays(1);
           leave.setDate(att.getDate());
           
       }else {
           leave.setEmployee(emp);
           leave.setBalanceLeaves(latest.getBalanceLeaves()-1);
           leave.setNoOfDays(latest.getNoOfDays()+1);
           leave.setDate(att.getDate());
       }

        return leave;
    }

}
