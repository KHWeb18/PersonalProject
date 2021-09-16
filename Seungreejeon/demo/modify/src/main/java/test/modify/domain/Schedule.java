package test.modify.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_no")
    private Long scheduleNo;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String team;

    @Column(length = 20, nullable = false)
    private String time8;

    @Column(length = 20, nullable = false)
    private String time9;

    @Column(length = 20, nullable = false)
    private String time10;

    @Column(length = 20, nullable = false)
    private String time11;

    @Column(length = 20, nullable = false)
    private String time12;

    @Column(length = 20, nullable = false)
    private String time13;

    @Column(length = 20, nullable = false)
    private String time14;

    @Column(length = 20, nullable = false)
    private String time15;

    @Column(length = 20, nullable = false)
    private String time16;

    @Column(length = 20, nullable = false)
    private String time17;

    @Column(length = 20, nullable = false)
    private String time18;

    @Column(length = 20, nullable = false)
    private String time19;

    @Column(length = 20, nullable = false)
    private String time20;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_no")
    private Employee employee;
}
