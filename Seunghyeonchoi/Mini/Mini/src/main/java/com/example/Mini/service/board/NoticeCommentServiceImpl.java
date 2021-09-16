package com.example.Mini.service.board;

import com.example.Mini.entity.board.Comment;
import com.example.Mini.entity.board.Notice;
import com.example.Mini.repository.board.NoticeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class NoticeCommentServiceImpl implements NoticeCommentService {

    @Autowired
    private NoticeCommentRepository repository;

    @Override
    public void register(Comment comment) throws Exception {
        repository.create(comment);
    }

    @Override
    public void remove(Integer commentNo) throws Exception {
        repository.delete(commentNo);
    }
}