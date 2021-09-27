package com.example.demo.repository;


import com.example.demo.entity.Calendar;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    @Query("select e from Employee e where e.email = :email")
    Optional<Employee> findByEmail(String email);
}
