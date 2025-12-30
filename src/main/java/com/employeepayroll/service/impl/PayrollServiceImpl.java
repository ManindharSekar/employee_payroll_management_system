package com.employeepayroll.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.employeepayroll.entity.*;
import com.employeepayroll.repository.LeaveRepository;
import com.employeepayroll.service.AttendanceService;
import com.employeepayroll.service.EmployeeService;
import com.employeepayroll.service.LeaveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.LeaveDTO;
import com.employeepayroll.dto.PayrollDTO;
import com.employeepayroll.repository.PayrollRepository;
import com.employeepayroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private LeaveService leaveService;

    private YearLeaveRule yearLeaveRule;

    private Leave leave;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<String> addPayRoll(PayrollDTO payRollDTO) {
        // TODO Auto-generated method stub
        Payroll payRoll = modelMapper.map(payRollDTO, Payroll.class);
        if (payRoll != null) {
            Employee employee = payRoll.getEmployee();
            double empSalary = employeeService.getEmpSalary(employee.getId());
            LocalDate today=LocalDate.now();

            List<Payroll> byMonthAndYear = payrollRepository.findByMonthAndYear(today.getMonth(), today.getYear());

            if(!byMonthAndYear.isEmpty()){
                return new ResponseEntity<>("Payment already exists in this month",HttpStatus.BAD_REQUEST);
            }

            payRoll.setDate(today);
            payRoll.setEmployee(payRoll.getEmployee());
            payRoll.setGrossSalary(empSalary);
            List<Leave> leavebyMonth=leaveService.findCurMonthEmpLeave(employee,today.getMonth(),today.getYear());

            if(leavebyMonth>)


            if(leave.getNoOfDays()>yearLeaveRule.getAnnualLeaveLimit()&&leave.getDate().getYear()==payRoll.getDate().getYear()){
                int leaveCount = leave.getNoOfDays() - yearLeaveRule.getAnnualLeaveLimit();
                payRollDTO.setLeaveDeduction(leaveCount*200);
            }

            List<Allowances> allowances = employeeService.getAllowancesForEmployee(employee.getId());
            for (Allowances allo : allowances) {
                if (allo.getAmountType().equalsIgnoreCase("PERCENTAGE")) {
                    payRollDTO.setPercTotal(payRollDTO.getPercTotal() + empSalary / allo.getValue());
                } else if (allo.getAmountType().equalsIgnoreCase("FIXED")) {
                    payRollDTO.setFixedTotal(payRollDTO.getFixedTotal() + allo.getValue());

                }
            }
            payRollDTO.setNetTotal(empSalary - payRollDTO.getFixedTotal() - payRollDTO.getPercTotal() - payRollDTO.getLeaveDeduction());
            payRollDTO.setDeduction(payRollDTO.getFixedTotal() + payRollDTO.getPercTotal() + payRollDTO.getLeaveDeduction());
            payRoll.setGrossSalary(empSalary);
            payRoll.setDeduction(payRollDTO.getDeduction());
            payRoll.setNet_salary(payRollDTO.getNetTotal());

        }
        payrollRepository.save(payRoll);
       return new ResponseEntity<>("PayRoll Created", HttpStatus.CREATED);
    }

}
