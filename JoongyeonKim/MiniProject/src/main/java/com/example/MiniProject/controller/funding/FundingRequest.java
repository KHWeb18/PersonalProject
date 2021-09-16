package com.example.MiniProject.controller.funding;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class FundingRequest {
    private String category;
    private String writer;
    private String title;
    private String image;
    private String content;
    private String summary;
    private String fundingEnd;
    private Long endMoney;
    private Long nowMoney;
}
