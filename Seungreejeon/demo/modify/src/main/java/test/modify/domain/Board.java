package test.modify.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String writer;

    @Column(length = 1000, nullable = false)
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    @Builder
    public Board(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_no")
    private Auth auth;

    public void addBoardAuth(Employee employee) {
        for (int i = 0; i < employee.getAuthList().toArray().length; i++) {
            AuthEnum check = employee.getAuthList().get(i).getAuth();
            if (check.equals(AuthEnum.ADMIN)) {
                this.auth = employee.getAuthList().get(i);
            }
            }
    }
}
