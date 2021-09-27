package com.example.writer.controller;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MypageBoardRequset {

    private String category;
    private String title;
    private String writer;
    private String content;
    private String tag;

}
