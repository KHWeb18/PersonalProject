package com.example.demo.controller.authentication;


import com.example.demo.controller.authentication.session.UserInfo;
import com.example.demo.entity.Board;
import com.example.demo.entity.Employee;
import com.example.demo.repository.*;
import com.example.demo.repository.receive.DeleteEmail;
import com.example.demo.repository.receive.EmployeeReceive;
import com.example.demo.service.CalendarService;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/authenticate")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Authentication {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    private HttpSession session;

    private UserInfo info;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody EmployeeReceive employeeReceive) throws Exception {
        log.info("EmployeeReceive" + employeeReceive.toString());

        Boolean checkDuplicate = employeeService.checkEmailValidation(employeeReceive.getEmail());

            if (checkDuplicate) {
                throw new Exception("중복이메일입니다.");
            }

        employeeService.signup(employeeReceive);


        return new ResponseEntity<Void> (HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody EmployeeReceive employeeReceive,
            HttpServletRequest request
    ) throws Exception {

        log.info("employeeReceive" + employeeReceive.toString());

        Integer isSuccess = employeeService.signin(employeeReceive);

        switch (isSuccess) {
            case 1:
            info.setErrorMessage(1);
                log.info("Login Failure");
                break;

            case 2:
            info.setErrorMessage(2);
                log.info("Login Failure");
                break;

                //보낼정보가 많아서 따로 만들필요가 없었던것같다 나중에 수정
            case 3:
                info = new UserInfo();
                Employee empInfo = employeeService.findInfo(employeeReceive.getEmail());
                info.setErrorMessage(3);
                log.info("Login Success");
                info.setEmail(empInfo.getEmail());
                info.setName(empInfo.getName());
                info.setTeam(empInfo.getTeam());

                Optional<Employee> empauth = employeeService.findByAuth(empInfo.getEmployeeNo());
                Employee emp = empauth.get();

                info.setAuth(emp.getAuthList().get(0).getAuth());
                log.info("auth" + info.getAuth());

               log.info("Session Info: " + info);
                session = request.getSession();
                session.setAttribute("emp", info);
                break;
        }
        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    @PostMapping("/logoutSession")
    public ResponseEntity<Optional> removeSession(HttpServletRequest request) throws Exception {

        Optional mustNull = null;

        log.info("Logout()" + mustNull);

        session.invalidate();

        return new ResponseEntity<Optional>(mustNull, HttpStatus.OK);
    }

    @PostMapping("/delete-account")
    public ResponseEntity<DeleteEmail> deleteEmployee(@RequestBody DeleteEmail deleteEmail) throws Exception {

        log.info("log" + deleteEmail.toString());

        Employee employeeEntity =  employeeService.findInfo(deleteEmail.getEmail());

        authRepository.deleteById(employeeEntity.getEmployeeNo());

        employeeService.deleteEmployee(employeeEntity.getEmployeeNo());

        return new ResponseEntity<DeleteEmail>(HttpStatus.OK);
    }

    @PostMapping("/check-duplicate")
    public ResponseEntity<Boolean> checkDuplicate(@RequestBody DeleteEmail deleteEmail) throws Exception {

        log.info("이메일중복체크"+ deleteEmail.toString());

        Boolean checkDuplicate = employeeService.checkEmailValidation(deleteEmail.getEmail());

        return new ResponseEntity<Boolean>(checkDuplicate, HttpStatus.OK);
    }

    @PostMapping("/find-account")
    public ResponseEntity<Employee> findInfor(@RequestBody Employee employee) throws Exception {
        log.info("findInfor () " + employee.toString());

        Employee PhoneNumber = new Employee();
        Employee name = new Employee();

        try {
            PhoneNumber = employeeService.findEmployeeInfoPhone(employee.getPhoneNumber());
            log.info("폰넘버 () " + PhoneNumber.toString());
//          phoneNumber, name 조회
            if (PhoneNumber != null) {
                log.info("존재하는 phoneNumber ()" + PhoneNumber.getPhoneNumber());

                name = employeeService.findEmployeeInfoname(employee.getName());
                log.info("이름조회 () " + name.getName());

                //            임시 비번 설정
                String newPassword = getRamdomPassword(10);
                log.info(newPassword);

                Optional<Employee> modify = employeeRepository.findById(name.getEmployeeNo());
                modify.ifPresent(selectEmployee -> {
                    selectEmployee.setPassword(newPassword);
                    employeeRepository.save(selectEmployee);
                });
                name.setPassword(newPassword);
            }
        } catch (Exception e) {
            log.info("이름 존재하지 않음" + employee.getName());
            name = null;
        }
        return new ResponseEntity<Employee>(name, HttpStatus.OK);
    }

//    난수 생성기 임시 비밀 번호용
    public String getRamdomPassword(int size) {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&' };
        StringBuffer sb = new StringBuffer(); SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());
        int idx = 0;
        int len = charSet.length;

        for (int i=0; i<size; i++) {
            idx = sr.nextInt(len);
            sb.append(charSet[idx]);
        }
        return sb.toString();
    }
}
