package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.BoardRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaBoardComment;
import com.example.market3.Rapository.BoardAuthRepository;
import com.example.market3.Rapository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JpaBoardServiceimpl implements JpaBoardService {

    @Autowired
    JpaBoardRepository repository;

    @Autowired
    BoardAuthRepository boardAuthRepository;

    @Override
    public void register(JpaBoard jpaBoard) throws Exception {
        repository.save(jpaBoard);
    }


    @Override
    public List<JpaBoard> boardlist() throws Exception {
        return repository.findAll();
    }

    @Override
    public Optional<JpaBoard> read(Long boardNo) throws Exception {
        return repository.findById(boardNo);
    }

    @Override
    public void commanents(BoardRequest boardRequest) throws Exception {
        JpaBoardComment jpaBoardComment = new JpaBoardComment(boardRequest.getBoardCommentNo(), boardRequest.getBoardNo(), boardRequest.getUi(), boardRequest.getComments(),boardRequest.getRegDate());

        boardAuthRepository.save(jpaBoardComment);
    }

    @Override
    public List<JpaBoardComment> finByComments(Long boardNo) throws Exception {
      //  return boardAuthRepository.findAllById(Collections.singleton(boardNo));
       return boardAuthRepository.finByComments(boardNo);
    }

    @Override
    public void CommunityModify(Long boardNo, String text) throws Exception {

      //  JpaBoard jpaBoard = new JpaBoard(boardRequest.getBoardNo(),boardRequest.getTitle(), boardRequest.getId(), boardRequest.getText(),boardRequest.getCreateDate(), boardRequest.getVuecount());
    //    repository.save(jpaBoard);

        repository.CommunityModify(boardNo, text);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        repository.deleteById(boardNo);
    }

    @Override
    public void vuecountupdate(Long boardNo) throws Exception {

        repository.updatevuecount(boardNo);

    }

    @Override
    public void commentModify(BoardRequest boardRequest) throws Exception {

        JpaBoardComment jpaBoardComment = new JpaBoardComment(boardRequest.getBoardCommentNo(), boardRequest.getBoardNo(), boardRequest.getUi(), boardRequest.getComments(),boardRequest.getRegDate());
        boardAuthRepository.save(jpaBoardComment);
    }

    @Override
    public void removeComment(Long boardCommentNo) throws Exception {

        boardAuthRepository.deleteById(boardCommentNo);
    }
}
