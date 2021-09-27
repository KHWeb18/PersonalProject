package com.example.Mini.service.board;

import com.example.Mini.entity.board.Comment;
import com.example.Mini.entity.board.Notice;

import java.util.List;

public interface NoticeCommentService {
    public void register(Comment comment) throws Exception;

    public void remove(Integer commentNo) throws Exception;
}