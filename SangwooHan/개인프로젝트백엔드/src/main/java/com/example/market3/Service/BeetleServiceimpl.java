package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.BeetleCommentRequest;
import com.example.market3.Entity.JpaBeetle;
import com.example.market3.Entity.JpaBeetleComment;
import com.example.market3.Rapository.BeetleCommentsRepository;
import com.example.market3.Rapository.BeetleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeetleServiceimpl implements BeetleService {
    @Autowired
    BeetleRepository beetleRepository;
    @Autowired
    BeetleCommentsRepository beetleCommentsRepository;

    @Override
    public void addBeetle(JpaBeetle jpabeetle) throws Exception {
        beetleRepository.save(jpabeetle);
    }

    @Override
    public List<JpaBeetle> BeetleList() throws Exception {
        return beetleRepository.findAll();
    }

    @Override
    public Optional<JpaBeetle> read(Long boardNo) throws Exception {
        return beetleRepository.findById(boardNo);
    }

    @Override
    public void addComment(BeetleCommentRequest beetleCommentRequest) throws  Exception {

        JpaBeetleComment jpaBeetleComment = new JpaBeetleComment(beetleCommentRequest.getBeetleCommentNo(),beetleCommentRequest.getBoardNo(), beetleCommentRequest.getUi(), beetleCommentRequest.getComments(),beetleCommentRequest.getRegDate());

        beetleCommentsRepository.save(jpaBeetleComment);
    }

    @Override
    public List<JpaBeetleComment> finyByCommentList(Long boardNo) throws Exception {
        return beetleCommentsRepository.finyByCommentList(boardNo);
    }

    @Override
    public void addvueCount(Long boardNo) throws Exception {
        beetleRepository.addvueCount(boardNo);
    }

    @Override
    public void ModifyComment(BeetleCommentRequest beetleCommentRequest) throws Exception {
        JpaBeetleComment jpaBeetleComment = new JpaBeetleComment(beetleCommentRequest.getBeetleCommentNo(),beetleCommentRequest.getBoardNo(), beetleCommentRequest.getUi(), beetleCommentRequest.getComments(),beetleCommentRequest.getRegDate());
        beetleCommentsRepository.save(jpaBeetleComment);

    }

    @Override
    public void DeleteComment(Long beetleCommentNo) throws Exception {

        beetleCommentsRepository.deleteById(beetleCommentNo);
    }

    @Override
    public Optional<JpaBeetle> searchtitle(BeetleCommentRequest beetleCommentRequest) throws Exception {
        String title = beetleCommentRequest.getTitle();

        Optional<JpaBeetle> jpaBeetle = beetleRepository.findBytitle(title);


        return jpaBeetle;
    }

    @Override
    public void Modify(Long boardNo, String text) throws Exception {

        beetleRepository.Modify(boardNo, text);

    }
}
