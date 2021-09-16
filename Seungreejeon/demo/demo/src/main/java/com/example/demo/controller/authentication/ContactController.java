package com.example.demo.controller.authentication;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ContactController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ContactService contactService;

    @GetMapping("/fetch-contactList")
    public ResponseEntity<List<Employee>> fetchContact() throws Exception {

//        List<Object[]> empEntity = contactService.getEmployeeList();
//        List<String> empList = new ArrayList<String>();
//        for (int i = 0; i < empEntity.size(); i++) {
////            debug
//            log.info(Arrays.toString(empEntity.get(i)));
//            empList.add(Arrays.toString(empEntity.get(i)));
//        }
//        log.info(empList.toString());

        log.info("fetchcontact"+contactService.getEmployeeList());

        List<Employee> empList = contactService.getEmployeeList();

        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }
}
