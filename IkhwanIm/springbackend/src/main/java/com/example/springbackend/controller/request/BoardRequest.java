package com.example.springbackend.controller.request;

import com.example.springbackend.entity.Board;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Slf4j
@NoArgsConstructor
public class BoardRequest {
    private Long boardNo;
    private String writer;
    private String title;
    private String link;
    private String content;
    private Date regDate;
    private Date updDate;


}
