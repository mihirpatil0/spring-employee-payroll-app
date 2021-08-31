package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO("Mihir", 400000);
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("Get Call Success : ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO("Mihir", 400000);
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("Get Call For Id Success : ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(40,employeePayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("Created Employee Payroll Data Successfully : ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("Employee Payroll Data Updated Successfully: ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : "+ empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
