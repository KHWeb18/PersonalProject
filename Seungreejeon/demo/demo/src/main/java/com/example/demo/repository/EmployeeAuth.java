package com.example.demo.repository;

import com.example.demo.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAuth extends JpaRepository<Auth, Long> {
}
