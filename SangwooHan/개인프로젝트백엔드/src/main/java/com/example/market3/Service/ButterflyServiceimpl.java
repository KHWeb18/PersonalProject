package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.ButterflyCommentRequest;
import com.example.market3.Entity.JpaButterfly;
import com.example.market3.Entity.JpaButterflyComment;
import com.example.market3.Rapository.ButterflyCommentRepository;
import com.example.market3.Rapository.ButterflyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ButterflyServiceimpl implements  ButterflyService {

    @Autowired
    ButterflyRepository butterflyRepository;
    @Autowired
    ButterflyCommentRepository butterflyCommentRepository;

    @Override
    public void register(JpaButterfly jpaButterfly) throws Exception {
        butterflyRepository.save(jpaButterfly);
    }

    @Override
    public List<JpaButterfly> getlist( ) throws Exception {
        return butterflyRepository.findAll();
    }

    @Override
    public Optional<JpaButterfly> getButterfly(Long boardNo) throws Exception {
        return butterflyRepository.findById(boardNo);
    }

    @Override
    public void vuecount(Long boardNo) throws Exception {
        butterflyRepository.vuecount(boardNo);
    }

    @Override
    public void comments(ButterflyCommentRequest butterflyCommentRequest) throws Exception {


        JpaButterflyComment jpaButterflyComment = new JpaButterflyComment(butterflyCommentRequest.getButterflyCommentNo(),butterflyCommentRequest.getBoardNo(),butterflyCommentRequest.getUi(),butterflyCommentRequest.getComments(),butterflyCommentRequest.getRegDate());
        butterflyCommentRepository.save(jpaButterflyComment);
    }

    @Override
    public void ModifyComments(ButterflyCommentRequest butterflyCommentRequest) throws Exception {
        JpaButterflyComment jpaButterflyComment = new JpaButterflyComment(butterflyCommentRequest.getButterflyCommentNo(),butterflyCommentRequest.getBoardNo(),butterflyCommentRequest.getUi(),butterflyCommentRequest.getComments(),butterflyCommentRequest.getRegDate());

        butterflyCommentRepository.save(jpaButterflyComment);

    }

    @Override
    public void deleteComment(Long butterflyCommentNo) throws Exception {
        butterflyCommentRepository.deleteById(butterflyCommentNo);
    }

    @Override
    public Optional<JpaButterfly> searchtitle(ButterflyCommentRequest butterflyCommentRequest) throws Exception {
        String title  = butterflyCommentRequest.getTitle();

        Optional<JpaButterfly> jpaButterfly = butterflyRepository.findBytitle(title);


        return jpaButterfly;
    }

    @Override
    public void Modify(Long boardNo, String text) throws Exception {

        butterflyRepository.Modify(boardNo, text);

    }
}
