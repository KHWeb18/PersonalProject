package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeAuthNo;

    @Column(name = "employee_no")
    private Long employeeNo;

    @Column(length = 30, nullable = false)
    private String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public Auth(String auth) {
        this.auth = auth;
    }
}
