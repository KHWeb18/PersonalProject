package com.example.Mini.service.board;

import com.example.Mini.entity.board.Comment;

import java.util.List;

public interface NoticeCommentService2 {
    public List<Comment> list(int boardNo) throws Exception;
}