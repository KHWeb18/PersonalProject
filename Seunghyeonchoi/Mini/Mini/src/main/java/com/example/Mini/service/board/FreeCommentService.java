package com.example.Mini.service.board;

import com.example.Mini.entity.board.Comment;

public interface FreeCommentService {
    public void register(Comment comment) throws Exception;

    public void remove(Integer commentNo) throws Exception;
}