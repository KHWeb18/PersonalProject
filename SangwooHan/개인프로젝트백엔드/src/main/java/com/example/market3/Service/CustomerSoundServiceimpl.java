package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.CustomerSoundCommentRequest;
import com.example.market3.Entity.CustomerSound;
import com.example.market3.Entity.CustomerSoundComment;
import com.example.market3.Rapository.CustomerSoundServiceCommentRepository;
import com.example.market3.Rapository.CustomerSoundServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSoundServiceimpl implements CustomerSoundService{

    @Autowired
    CustomerSoundServiceRepository customerSoundServiceRepository;
    @Autowired
    CustomerSoundServiceCommentRepository customerSoundServiceCommentRepository;

    @Override
    public void register(CustomerSound customerSound) throws Exception {

        customerSoundServiceRepository.save(customerSound);
    }

    @Override
    public List<CustomerSound> getSoundList() throws Exception {
        return customerSoundServiceRepository.findAll();
    }

    @Override
    public Optional<CustomerSound> getSound(Long boardNo) throws Exception {
        return customerSoundServiceRepository.findById(boardNo);
    }

    @Override
    public void comment(CustomerSoundCommentRequest customerSoundCommentRequest) throws Exception {

        CustomerSoundComment customerSoundComment = new CustomerSoundComment(customerSoundCommentRequest.getCustomerSoundBoardNo(),customerSoundCommentRequest.getBoardNo(),customerSoundCommentRequest.getUi(),customerSoundCommentRequest.getComments(),customerSoundCommentRequest.getRegDate());
        customerSoundServiceCommentRepository.save(customerSoundComment);
    }

    @Override
    public void vuecount(Long boardNo) throws Exception {

        customerSoundServiceRepository.addvuecount(boardNo);
    }

    @Override
    public void commentModify(Long customerSoundBoardNo, String comments) throws Exception {

        customerSoundServiceCommentRepository.commentModify(customerSoundBoardNo,comments);
    }

    @Override
    public void deleteComment(Long customerSoundBoardNo) throws Exception {

        customerSoundServiceCommentRepository.deleteById(customerSoundBoardNo);
    }
}
