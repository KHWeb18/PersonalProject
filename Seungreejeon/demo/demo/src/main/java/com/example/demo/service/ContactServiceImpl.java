package com.example.demo.service;


import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeRepository.findAll();
    }
}
