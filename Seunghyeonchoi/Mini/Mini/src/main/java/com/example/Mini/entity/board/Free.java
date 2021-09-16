package com.example.Mini.entity.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Free {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private String nickname;
    private Date regDate;
}
