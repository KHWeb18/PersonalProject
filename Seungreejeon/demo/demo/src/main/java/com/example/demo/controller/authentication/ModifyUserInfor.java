package com.example.demo.controller.authentication;


import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/userInfo")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ModifyUserInfor {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/modify")
    public ResponseEntity<Employee> modifyInfor(@RequestBody Employee employee) throws Exception {

        log.info("modifyInfor : " + employee.toString());

        Employee Employee = employeeService.findInfo(employee.getEmail());

        Long findId = Employee.getEmployeeNo();

        Optional<Employee> modifyEntity = repository.findById(findId);

        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);

        modifyEntity.ifPresent(selectEmp -> {
            selectEmp.setPassword(employee.getPassword());

            repository.save(selectEmp);
        });

        return new ResponseEntity<Employee>(HttpStatus.OK);
    }


}
