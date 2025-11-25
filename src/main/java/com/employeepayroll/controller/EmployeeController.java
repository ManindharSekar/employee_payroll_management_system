package com.employeepayroll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.entity.Employee;
import com.employeepayroll.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employee) {
        log.info("Request received to create Employee {}", employee);
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getEmployee/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        log.info("Request received from employee id:{}", id);
        return employeeService.getEmployee(id);

    }

}
