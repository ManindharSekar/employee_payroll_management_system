package com.employeepayroll.service.impl;

import java.util.List;

import com.employeepayroll.entity.*;
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
    private EmployeeServiceImpl employeeService;

    @Autowired
    private LeaveServiceImpl leaveService;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<String> addPayRoll(PayrollDTO payRollDTO) {
        // TODO Auto-generated method stub
        Payroll payRoll = modelMapper.map(payRollDTO, Payroll.class);
        if (payRoll != null) {
            Employee employee = payRoll.getEmployee();
            double empSalary = employeeService.getEmpSalary(employee.getId());
            List<LeaveDTO> lastOneMonthData = leaveService.getLastOneMonthData(payRoll.getDate());
            for (LeaveDTO emp : lastOneMonthData) {
                payRollDTO.setDays(emp.getDays() + payRollDTO.getDays());
            }
            if (employee.getLeaveRule().getAnnualLeaveLimit() > payRollDTO.getDays()) {
                payRollDTO.setLeaveDeduction(payRollDTO.getDays() * 200);
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
