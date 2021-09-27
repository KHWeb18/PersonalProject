package com.example.market3.Controller1.MemberRequset;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class NoticeCommentRequest {
    private Long boardNo;
    private String id;
    private String title;
    private String text;
    private String ui;
    private String comments;
    private LocalDateTime createDate;
    private Integer vuecount;
    private Long noticeCommentNo;
    private Date regDate;


}
