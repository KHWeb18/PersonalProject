package com.example.demo_ver.entity.jpa;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Entity
@Table
@NoArgsConstructor
public class SecondAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String email;

    @Getter
    @Column(nullable = false)
    private String password;

    public SecondAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
