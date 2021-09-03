package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employeepayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * This api handles get request and gives back
     * list of all the employees' information in json format.
     *
     * @return ResponseDTO which has employees information in json format.
     */
    @GetMapping("/employees")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        List<EmployeePayrollData> employeeDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO =  new ResponseDTO("Get Call Success : ", employeeDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles request and gives back specific employee details
     * against given employee id.
     *
     * @param empId - represent employee id.
     * @return ResponseDTO which has employee information in json format.
     */
    @GetMapping("/employee/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {

        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful : ", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handle post request,
     * accepts employee information and store it.
     *
     * @param employeePayrollDTO - has employee information which is passed by post request.
     * @return ResponseDTO - which has appropriate message for post request along with employee information.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
    {

        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully : ", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles put request.
     * update existing employee information provided by the user.
     *
     * @param empId - used to check if the employee related to provided id is present or not.
     * @param employeePayrollDTO - carry information to be updated for the employee.
     * @return ResponseDTO - which has appropriate message for put request along with employee information.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
    {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("Employee Payroll Data Updated Successfully: ", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles delete request.
     * If the employee is present for the provided employee id then delete that record.
     *
     * @param empId - checks for the employee is present or not if yes delete that record.
     * @return ResponseDTO - which has appropriate message for delete request.
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : "+ empId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
