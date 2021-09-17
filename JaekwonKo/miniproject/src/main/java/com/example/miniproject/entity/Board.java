package com.example.miniproject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private Integer boardNo;
    private String writer;
    private String content;
    private float rating;
    private String area;
    private String store;
    private Date regDate;
}
