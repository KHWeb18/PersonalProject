package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Long projectNo;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private String team;

    @Column(length = 20, nullable = false)
    private String person;

    @Column(length = 20, nullable = false)
    private String due;

    @Column(length = 10, nullable = false)
    private String status;

}
