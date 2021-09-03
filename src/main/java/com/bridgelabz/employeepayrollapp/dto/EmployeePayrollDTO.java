package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot be null.")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$",message = "Employee name is Invalid")
    public String name;

    @Min(value = 500, message = "Minimum wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "StartDate should not be empty")
    @PastOrPresent(message = "StartDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    public String note;

    @NotBlank(message = "ProfilePic cannot be empty")
    public String profilePic;

    @NotNull(message = "Department should not be empty")
    public List<String> departments;
}
