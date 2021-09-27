package com.example.springbackend.service;

import com.example.springbackend.controller.request.CommentRequest;
import com.example.springbackend.entity.Comment;
import com.example.springbackend.repository.BoardRepository;
import com.example.springbackend.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void register(CommentRequest commentRequest) throws Exception {
        Comment commentEntity = new Comment(commentRequest.getCommentNo(), commentRequest.getBoardNo(),
                commentRequest.getWriter(), commentRequest.getContent(), commentRequest.getRegDate());

        commentRepository.save(commentEntity);
    }
    @Override
    public List<Comment> getCommentsOfBoard(Long boardNo) throws Exception {
        return commentRepository.getCommentsOfBoard(boardNo);
    }

    @Override
    public List<Comment> findByCommentNo(Long commentNo) throws Exception {
        return commentRepository.findByCommentNo(commentNo);
    }

    @Override
    public void modify(Comment comment, CommentRequest commentRequest) throws Exception {
        comment.updateComment(commentRequest);
        commentRepository.save(comment);
    }
}
