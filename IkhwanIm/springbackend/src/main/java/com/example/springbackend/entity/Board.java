package com.example.springbackend.entity;

import com.example.springbackend.controller.request.BoardRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(length = 8000, nullable = false)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private Date updDate;

    // comment
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "board_no")
    private List<Comment> commentList = new ArrayList<Comment>();

    public Board(Long boardNo, String writer, String title, String link, String content, Date regDate, Date updDate) {
        this.boardNo = boardNo;
        this.writer = writer;
        this.title = title;
        this.link = link;
        this.content = content;
        this.regDate = regDate;
        this.updDate = updDate;
    }

    public void updateBoard(BoardRequest boardRequest) {
        this.title = boardRequest.getTitle();
        this.link = boardRequest.getLink();
        this.content = boardRequest.getContent();
        this.updDate = boardRequest.getUpdDate();
    }

}
