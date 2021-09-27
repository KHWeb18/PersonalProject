package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_no")
    private Long employeeNo;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 20, nullable = false)
    private String team;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_no")
    private List<Auth> authList = new ArrayList<Auth>();

    public Employee(String email, String password, String phoneNumber, String team, String name) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.team = team;
        this.name = name;
    }

    public void addAuth(Auth auth) {
        authList.add(auth);
    }
}
