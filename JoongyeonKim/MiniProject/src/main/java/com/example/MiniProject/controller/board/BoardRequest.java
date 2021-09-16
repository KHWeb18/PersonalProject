package com.example.MiniProject.controller.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class BoardRequest {
    private String email;
    private String title;
    private String content;
}
