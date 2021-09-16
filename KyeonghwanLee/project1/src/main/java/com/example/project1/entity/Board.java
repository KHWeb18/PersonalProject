package com.example.project1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private Integer boardNo;
    // th:field로 맵핑됨
    private String title;
    // 수정
    private String content;
    private String writer;
    private String regDate;
}
