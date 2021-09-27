package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.CustomerSoundCommentRequest;
import com.example.market3.Entity.CustomerSound;

import java.util.List;
import java.util.Optional;

public interface CustomerSoundService {

    public  void register(CustomerSound customerSound) throws  Exception ;

    public List<CustomerSound> getSoundList ()throws Exception;

    public Optional<CustomerSound> getSound(Long boardNo) throws  Exception ;

    public  void  comment (CustomerSoundCommentRequest  customerSoundCommentRequest)throws  Exception;

    public void vuecount(Long boardNo) throws  Exception;

    public  void commentModify(Long customerSoundBoardNo, String comments) throws  Exception ;

    public  void deleteComment (Long customerSoundBoardNo) throws  Exception ;

}
