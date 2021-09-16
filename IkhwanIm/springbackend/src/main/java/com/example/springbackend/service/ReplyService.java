package com.example.springbackend.service;

import com.example.springbackend.controller.request.ReplyRequest;
import com.example.springbackend.entity.Reply;

import java.util.List;

public interface ReplyService {
    public void register(ReplyRequest replyRequest) throws Exception;
    public List<Reply> getRepliesOfComment(Long commentNo) throws Exception;
    public List<Reply> findByReplyNo(Long replyNo) throws Exception;
    public void modify(Reply reply, ReplyRequest replyRequest) throws Exception;
}
