package test.modify.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.naming.AuthenticationException;
import javax.persistence.*;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_no")
    private Long authNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_no")
    private Employee employee;

    @Enumerated(value = EnumType.STRING)
    private AuthEnum auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public Auth(AuthEnum auth) {
        this.auth = auth;
    }

    @OneToMany(mappedBy = "auth", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();


    public void validateAuth(Employee employee) throws AccessDeniedException {
        for (int i = 0; i < employee.getAuthList().toArray().length; i++) {
            AuthEnum check = employee.getAuthList().get(i).getAuth();
            if (check.equals(AuthEnum.ADMIN)) {
                return;
            }
        }
        throw new AccessDeniedException("권한이 없습니다.");
    }

}
