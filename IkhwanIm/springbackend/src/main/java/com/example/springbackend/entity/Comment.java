package com.example.springbackend.entity;

import com.example.springbackend.controller.request.CommentRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Comment")
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long commentNo;

    @Column(nullable = false)
    private Long board_no;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "comment_no")
    private List<Reply> replyList = new ArrayList<Reply>();

    public Comment(Long commentNo, Long boardNo, String writer, String content, Date regDate){
        this.commentNo = commentNo;
        this.board_no = boardNo;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
    }

    public void updateComment(CommentRequest commentRequest){
        this.writer = commentRequest.getWriter();
        this.content = commentRequest.getContent();
    }
}
