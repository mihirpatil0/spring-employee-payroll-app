package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String> getEmployeePayrollData()
    {
        return new ResponseEntity<String>("Get Call Success: ", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        return new ResponseEntity<String>("Get Call Success: " + empId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        return new ResponseEntity<String>("Created Employee Payroll Data For : " + employeePayrollDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        return new ResponseEntity<String>("Update Employee Payroll Data For : " + employeePayrollDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        return new ResponseEntity<String>("Delete Call Success For Id : " + empId,HttpStatus.OK);
    }
}
