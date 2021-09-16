package com.example.Mini.entity.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString

public class Comment {
    private int commentNo;
    private int boardNo;
    private String content;
    private String writer;
    private String nickname;
    private Timestamp regDate;


}
