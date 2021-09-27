package com.pettalk.pettalkbackend.dto.board;

import lombok.Data;

@Data
public class BoardRequest {
    public String title;
    public String content;
    public Long writer;
}
