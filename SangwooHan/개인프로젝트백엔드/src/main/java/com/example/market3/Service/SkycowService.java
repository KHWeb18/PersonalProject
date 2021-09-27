package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.SkycowCommentRequest;
import com.example.market3.Entity.JpaSkycow;

import java.util.List;
import java.util.Optional;

public interface SkycowService {

    public void register(JpaSkycow jpaSkycow) throws  Exception;

    public List<JpaSkycow> getSkycowlist() throws  Exception;

    public Optional<JpaSkycow> getSkycow(Long boardNo) throws  Exception;

    public  void comments(SkycowCommentRequest skycowCommentRequest) throws  Exception;

    public  void vuecount( Long boardNo) throws  Exception;

    public  void ModifyComments(SkycowCommentRequest skycowCommentRequest) throws  Exception;

    public  void deleteComment(Long skycowCommentsNo);

    public  Optional<JpaSkycow> searchtitle( SkycowCommentRequest skycowCommentRequest) throws  Exception;

    public  void Modify(Long boardNo, String text) throws  Exception;

}
