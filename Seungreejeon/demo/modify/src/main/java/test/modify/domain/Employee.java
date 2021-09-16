package test.modify.domain;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
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

    @Embedded
    private Address address;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_no")
    private List<Auth> authList = new ArrayList<Auth>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_no")
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
    private List<Calendar> calendars = new ArrayList<>();

    @Builder
    public Employee(String email, String password, String phoneNumber, String name, Address address) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
    }

    public void addTeam(Team team) {
        this.team = team;
    }

    public void addAuth(Auth auth) {
        authList.add(auth);
    }
}
