package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.StagbeetleCommentRuquest;
import com.example.market3.Entity.JpaStagbeetle;
import com.example.market3.Entity.JpaStagbeetleComment;
import com.example.market3.Rapository.StagbeetleCommentRepository;
import com.example.market3.Rapository.StagbeetleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagbeetleServiceimpl implements StagbeetleService{

    @Autowired
    StagbeetleRepository stagbeetleRepository;
    @Autowired
    StagbeetleCommentRepository stagbeetleCommentRepository;

    @Override
    public void register(JpaStagbeetle jpaStagbeetle) throws Exception {
        stagbeetleRepository.save(jpaStagbeetle);
    }

    @Override
    public List<JpaStagbeetle> StagbeetleList() throws Exception {
        return stagbeetleRepository.findAll();
    }

    @Override
    public Optional<JpaStagbeetle> read(Long boardNo) throws Exception {
        return stagbeetleRepository.findById(boardNo);
    }

    @Override
    public void addComment(StagbeetleCommentRuquest stagbeetleCommentRuquest) throws Exception {

        JpaStagbeetleComment jpaStagbeetleComment = new JpaStagbeetleComment(stagbeetleCommentRuquest.getStagbeetleCommentNo(),stagbeetleCommentRuquest.getBoardNo(), stagbeetleCommentRuquest.getUi(), stagbeetleCommentRuquest.getComments(),stagbeetleCommentRuquest.getRegDate());

        stagbeetleCommentRepository.save(jpaStagbeetleComment);
    }

    @Override
    public List<JpaStagbeetleComment> finyByCommentList(Long boardNo) throws Exception {
        return stagbeetleCommentRepository.finyByCommentList(boardNo);
    }

    @Override
    public void addvueCount(Long boardNo) throws Exception {

        stagbeetleRepository.addvueCount(boardNo);

    }

    @Override
    public void ModifyComments(StagbeetleCommentRuquest stagbeetleCommentRuquest) {
        JpaStagbeetleComment jpaStagbeetleComment = new JpaStagbeetleComment(stagbeetleCommentRuquest.getStagbeetleCommentNo(),stagbeetleCommentRuquest.getBoardNo(), stagbeetleCommentRuquest.getUi(), stagbeetleCommentRuquest.getComments(),stagbeetleCommentRuquest.getRegDate());

        stagbeetleCommentRepository.save(jpaStagbeetleComment);
    }

    @Override
    public void deleteComment(Long StagbeetleCommentNo) throws Exception {

        stagbeetleCommentRepository.deleteById(StagbeetleCommentNo);
    }

    @Override
    public Optional<JpaStagbeetle> searchtitle(StagbeetleCommentRuquest stagbeetleCommentRuquest) {
        String title = stagbeetleCommentRuquest.getTitle();

       Optional<JpaStagbeetle> jpaStagbeetle = stagbeetleRepository.findBytitle(title);

        return jpaStagbeetle;
    }

    @Override
    public void Modify(Long boardNo,String text) throws Exception {

        stagbeetleRepository.Modify(boardNo,text);
    }
}
