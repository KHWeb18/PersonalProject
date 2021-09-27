package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Getter
@Setter
@ToString
public class Board {

    private Integer boardNo;
    private String title;
    private String content;
    private String writer;
    private String img;
    private int funding;
    private int nowfunding;
    private Date regDate;


}
