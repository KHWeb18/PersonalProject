package com.pettalk.pettalkbackend.dto.comment;

import lombok.Data;

@Data
public class CommentRequest {
    public String content;
    public Long writer;
}
