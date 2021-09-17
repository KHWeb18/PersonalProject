package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.StagbeetleCommentRuquest;
import com.example.market3.Entity.JpaStagbeetle;
import com.example.market3.Entity.JpaStagbeetleComment;

import java.util.List;
import java.util.Optional;

public interface StagbeetleService {

    public void register(JpaStagbeetle jpaStagbeetle) throws  Exception;

    public List<JpaStagbeetle> StagbeetleList () throws  Exception;

    public Optional<JpaStagbeetle> read(Long boardNo) throws Exception;

    public void addComment(StagbeetleCommentRuquest stagbeetleCommentRuquest)  throws  Exception;

    public List<JpaStagbeetleComment> finyByCommentList( Long boardNo) throws  Exception;

    public void addvueCount(Long boardNo) throws Exception;

    public  void ModifyComments(StagbeetleCommentRuquest stagbeetleCommentRuquest);

    public  void deleteComment(Long StagbeetleCommentNo) throws  Exception;

    public  Optional<JpaStagbeetle>searchtitle (StagbeetleCommentRuquest stagbeetleCommentRuquest);

    public  void Modify(Long boardNo,String text) throws  Exception ;

}
