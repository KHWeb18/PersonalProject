package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_no")
    private Long calendarNo;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String details;

    @Column(length = 100, nullable = false)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

//    @Column(length = 20, nullable = false)
//    private String start;
//
//    @Column(length = 20, nullable = false)
//    private String end;

    @Column(length = 10, nullable = false)
    private String color;
}
