package com.example.springbackend.service;

import com.example.springbackend.controller.request.ReplyRequest;
import com.example.springbackend.entity.Reply;
import com.example.springbackend.repository.CommentRepository;
import com.example.springbackend.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public void register(ReplyRequest replyRequest) throws Exception {
        Reply replyEntity = new Reply(replyRequest.getReplyNo(), replyRequest.getCommentNo(),
                replyRequest.getWriter(), replyRequest.getContent(), replyRequest.getRegDate());

        replyRepository.save(replyEntity);
    }

    @Override
    public List<Reply> getRepliesOfComment(Long commentNo) throws Exception {
        return replyRepository.getRepliesOfComment(commentNo);
    }

    @Override
    public List<Reply> findByReplyNo(Long replyNo) throws Exception {
        return replyRepository.findByReplyNo(replyNo);
    }

    @Override
    public void modify(Reply reply, ReplyRequest replyRequest) throws Exception {
        reply.updateReply(replyRequest);
        replyRepository.save(reply);
    }
}
