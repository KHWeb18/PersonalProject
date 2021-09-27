package com.example.demo.service;


import com.example.demo.entity.Auth;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeAuth;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.receive.EmployeeReceive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeAuth employeeAuth;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signup(EmployeeReceive employeeReceive) throws Exception {
        String encodedPassword = passwordEncoder.encode(employeeReceive.getPassword());
        employeeReceive.setPassword(encodedPassword);

        Auth authEntity = new Auth(employeeReceive.getAuth());
        Employee employeeEntity = new Employee(
                employeeReceive.getEmail(), employeeReceive.getPassword(), employeeReceive.getPhoneNumber(), employeeReceive.getTeam(), employeeReceive.getName());
        employeeEntity.addAuth(authEntity);

        employeeRepository.save(employeeEntity);

    }

    @Override
    public Integer signin(EmployeeReceive employeeReceive) throws Exception {

        Optional<Employee> certifyEmp = employeeRepository.findByEmail(employeeReceive.getEmail());

        log.info("certifyEmp : " + certifyEmp);

        Object compare = Optional.empty();

        if (certifyEmp == compare)
        {
            log.info("등록되지 않은 Email");
            return 1;
        }

        Employee signinEmp = certifyEmp.get();

        log.info("certifyEmp.get() : " + certifyEmp.get());

//      임시비밀번호용

        Employee tempPassword = employeeRepository.findInfo(employeeReceive.getEmail());

//        log.info("db비번"+tempPassword.getPassword());
//
//        log.info("받은비번"+employeeReceive.getPassword());

        if (tempPassword.getPassword().equals(employeeReceive.getPassword())) {
            log.info("임시비밀번호 () ");
            return 3;

        } else if (!passwordEncoder.matches(employeeReceive.getPassword(), signinEmp.getPassword())) {
            log.info("비밀번호가 일치하지 않습니다.");
            return 2;
        }

        return 3;
    }

    @Override
    public Optional<Employee> findByAuth(Long employeeNo) {
        return employeeRepository.findById(employeeNo);
    }

    @Override
    public Employee findInfo(String email) throws Exception {
        return employeeRepository.findInfo(email);
    }

//    @Override
//    public void deleteAuth(Long employeeNo) throws Exception {
//        employeeRepository.findByAuthDelete(employeeNo);
//    }

    @Override
    public void deleteEmployee(Long employeeNo) throws Exception {
        employeeRepository.deleteById(employeeNo);
    }

    @Override
    public boolean checkEmailValidation(String email) throws Exception {
        Optional<Employee> checkEmail = employeeRepository.findByEmail(email);

        Object compare = Optional.empty();

        if (checkEmail == compare)
        {
            log.info("login(): 사용가능한 이메일");
            return false;
        }

        log.info("login(): 중복되는 이메일");
        return true;
    }

    @Override
    public Employee findEmployeeInfoname(String name) throws Exception {
        return employeeRepository.findEmployeeInfoName(name);
    }

    @Override
    public Employee findEmployeeInfoPhone(String phoneNumber) throws Exception {
        return employeeRepository.findEmployeeInfoPhoneNumber(phoneNumber);
    }
}
