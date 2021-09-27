package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.ButterflyCommentRequest;
import com.example.market3.Entity.JpaButterfly;

import java.util.List;
import java.util.Optional;

public interface ButterflyService {

    public  void register (JpaButterfly jpaButterfly) throws  Exception ;

    public List<JpaButterfly> getlist() throws  Exception;

    public Optional<JpaButterfly> getButterfly(Long boardNo) throws  Exception;

    public  void vuecount(Long boardNo) throws  Exception ;

    public  void comments(ButterflyCommentRequest butterflyCommentRequest) throws  Exception;

    public  void ModifyComments(ButterflyCommentRequest butterflyCommentRequest)throws  Exception;

    public void deleteComment(Long butterflyCommentNo ) throws  Exception;

    public Optional<JpaButterfly> searchtitle(ButterflyCommentRequest butterflyCommentRequest) throws  Exception;

    public  void Modify(Long boardNo , String text) throws  Exception ;
}
