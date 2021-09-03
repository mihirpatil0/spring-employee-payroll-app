package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private final List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    /**
     * This method gives all the employee information.
     *
     * @return employeePayrollDataList - which is an array list which has all the employee information.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }

    /**
     * This method returns single employee information with respect to provided empId.
     *
     * @param empId - hold number that represent specific employee.
     * @return employeePayrollDataList - list with single employee data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollDataList.stream()
                .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Requested Employee For An Given Id Is Not Found."));
    }

    /**
     * Store employee information.
     *
     * @param employeePayrollDTO which consist employee name and salary.
     * @return Same employee object which has been created.
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Employee Data " + employeePayrollData);
        employeePayrollDataList.add(employeePayrollData);
        return employeePayrollRepository.save(employeePayrollData);
    }

    /**
     * This method update employee information with respect to given id.
     *
     * @param empId Represent which employee details to be updated.
     * @param employeePayrollDTO Holds new updated employee details.
     * @return same object.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    /**
     * This method delete employee with respect to given employee id.
     *
     * @param empId holds employee id.
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.remove(empId-1);
    }
}
