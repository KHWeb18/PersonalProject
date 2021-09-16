package com.example.springbackend.entity;

import com.example.springbackend.controller.request.CommentRequest;
import com.example.springbackend.controller.request.ReplyRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reply")
@NoArgsConstructor
@Data
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long replyNo;

    @Column(nullable = false)
    private Long comment_no;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    public Reply(Long replyNo, Long commentNo, String writer, String content, Date regDate){
        this.replyNo = replyNo;
        this.comment_no = commentNo;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
    }

    public void updateReply(ReplyRequest replyRequest){
        this.writer = replyRequest.getWriter();
        this.content = replyRequest.getContent();
    }
}
