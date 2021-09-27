package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.BeetleCommentRequest;
import com.example.market3.Entity.JpaBeetle;
import com.example.market3.Entity.JpaBeetleComment;

import java.util.List;
import java.util.Optional;

public interface BeetleService {

    public void addBeetle (JpaBeetle jpabeetle) throws  Exception;

    public List<JpaBeetle> BeetleList() throws Exception;

    public Optional<JpaBeetle> read (Long boardNo) throws Exception;

    public  void addComment(BeetleCommentRequest beetleCommentRequest)throws Exception;

    public  List<JpaBeetleComment> finyByCommentList(Long boardNo) throws  Exception;

    public  void addvueCount(Long boardNo) throws  Exception;

    public  void ModifyComment (BeetleCommentRequest beetleCommentRequest)throws  Exception;

    public  void DeleteComment(Long beetleCommentNo)throws  Exception;

    public  Optional<JpaBeetle> searchtitle(BeetleCommentRequest beetleCommentRequest) throws  Exception;

    public  void Modify(Long boardNo ,  String text) throws  Exception;


}
