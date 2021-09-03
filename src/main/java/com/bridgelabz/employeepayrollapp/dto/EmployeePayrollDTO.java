package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot be null.")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$",message = "Employee name is Invalid")
    public String name;

    @Min(value = 500, message = "Minimum wage should be more than 500")
    public long salary;

    public String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;
}
