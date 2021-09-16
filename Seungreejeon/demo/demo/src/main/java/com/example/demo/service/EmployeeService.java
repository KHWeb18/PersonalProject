package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.receive.EmployeeReceive;

import java.util.Optional;

public interface EmployeeService {

    public void signup(EmployeeReceive employeeReceive) throws Exception;

    public Integer signin(EmployeeReceive employeeReceive) throws Exception;

    public Optional<Employee> findByAuth(Long employeeNo);

    public Employee findInfo(String email) throws Exception;

//    public void deleteAuth(Long employeeNo) throws Exception;

    public void deleteEmployee(Long employeeNo) throws Exception;

    public boolean checkEmailValidation(String email) throws Exception;


    public Employee findEmployeeInfoname(String name) throws Exception;

    public Employee findEmployeeInfoPhone(String phoneNumber) throws Exception;



}
