package test.modify.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_no")
    private Long team_no;

    @Enumerated(value = EnumType.STRING)
    private TeamEnum team;

    @OneToMany(mappedBy = "team", orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "team", orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

    public Team(TeamEnum team) {
        this.team = team;
    }

//    public void addProject(Project project) {
//        this.projects.add(project);
//    }
//
//    public void addEmployee(Employee employee) {
//        this.employees.add(employee);
//    }
}
