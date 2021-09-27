package test.modify.domain;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Long projectNo;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private String person;

    @Column(length = 20, nullable = false)
    private String due;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_no")
    public Team team;

    @Builder
    public Project(String title, String person, String due, StatusEnum status) {
        this.title = title;
        this.person = person;
        this.due = due;
        this.status = status;
    }

    public void addTeam(Team team) {
        this.team = team;
    }
}
