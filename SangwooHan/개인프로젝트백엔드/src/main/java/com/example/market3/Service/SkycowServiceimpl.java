package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.SkycowCommentRequest;
import com.example.market3.Entity.JpaSkycow;
import com.example.market3.Entity.JpaSkycowComment;
import com.example.market3.Rapository.SkycowCommentRepository;
import com.example.market3.Rapository.SkycowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;

@Service
public class SkycowServiceimpl implements  SkycowService {

    @Autowired
    SkycowRepository skycowRepository;
    @Autowired
    SkycowCommentRepository skycowCommentRepository;


    @Override
    public void register(JpaSkycow jpaSkycow) throws Exception {
        skycowRepository.save(jpaSkycow);
    }

    @Override
    public List<JpaSkycow> getSkycowlist() throws Exception {
        return skycowRepository.findAll();
    }

    @Override
    public Optional<JpaSkycow> getSkycow(Long boardNo) throws Exception {
        return skycowRepository.findById(boardNo);
    }

    @Override
    public void comments(SkycowCommentRequest skycowCommentRequest) throws Exception {

        JpaSkycowComment jpaSkycowComment = new JpaSkycowComment(skycowCommentRequest.getSkycowCommentsNo(),skycowCommentRequest.getBoardNo(),skycowCommentRequest.getUi(), skycowCommentRequest.getComments(),skycowCommentRequest.getRegDate());

        skycowCommentRepository.save(jpaSkycowComment);

    }

    @Override
    public void vuecount(Long boardNo) throws Exception {
        skycowRepository.vuecount(boardNo);
    }

    @Override
    public void ModifyComments(SkycowCommentRequest skycowCommentRequest) throws Exception {
        JpaSkycowComment jpaSkycowComment = new JpaSkycowComment(skycowCommentRequest.getSkycowCommentsNo(),skycowCommentRequest.getBoardNo(),skycowCommentRequest.getUi(), skycowCommentRequest.getComments(),skycowCommentRequest.getRegDate());


        skycowCommentRepository.save(jpaSkycowComment);

    }

    @Override
    public void deleteComment(Long skycowCommentsNo) {
        skycowCommentRepository.deleteById(skycowCommentsNo);
    }

    @Override
    public Optional<JpaSkycow> searchtitle(SkycowCommentRequest skycowCommentRequest) throws Exception {
        String title  = skycowCommentRequest.getTitle();

        Optional<JpaSkycow> jpaSkycow = skycowRepository.findBytitle(title);
        return jpaSkycow;
    }

    @Override
    public void Modify(Long boardNo, String text) throws Exception {

        skycowRepository.Modify(boardNo,text);
    }
}
