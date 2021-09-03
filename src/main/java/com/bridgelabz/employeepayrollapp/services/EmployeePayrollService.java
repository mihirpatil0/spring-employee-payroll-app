package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    /**
     * This method gives all the employee information.
     *
     * @return All the employee.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }

    /**
     * This method returns single employee information with respect to provided empId.
     *
     * @param empId - hold number that represent specific employee.
     * @return Updated information of employee, if not present gives error message.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(
                        () -> new EmployeePayrollException("Employee with employeeId " + empId + " does not exists..!!"));
    }

    /**
     * This methods gives back employee which is associated with given department.
     *
     * @param department
     * @return
     */
    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department){
        return employeePayrollRepository.findEmployeesByDepartment(department);
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
        employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    /**
     * This method delete employee with respect to given employee id.
     *
     * @param empId holds employee id.
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(employeePayrollData);
    }
}
