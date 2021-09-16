package com.example.demo.entity.jpa.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vueboard")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 100, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public Board(String writer, String title, String content, Date regDate, Date upDate) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.upDate = upDate;
    }
}
