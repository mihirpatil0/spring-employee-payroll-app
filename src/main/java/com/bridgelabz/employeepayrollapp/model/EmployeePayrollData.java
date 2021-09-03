package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public EmployeePayrollData() {}

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;
    }
}
