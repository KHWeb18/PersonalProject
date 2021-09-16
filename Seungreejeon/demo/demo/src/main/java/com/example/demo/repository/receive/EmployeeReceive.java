package com.example.demo.repository.receive;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeReceive {

    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private String team;
    private String auth;

}
