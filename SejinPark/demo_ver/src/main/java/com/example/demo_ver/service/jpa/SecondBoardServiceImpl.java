package com.example.demo_ver.service.jpa;

import com.example.demo_ver.entity.jpa.SecondBoard;
import com.example.demo_ver.repository.jpa.JPASecondBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondBoardServiceImpl implements SecondBoardService {

    @Autowired
    private JPASecondBoardRepository repository;
    @Override
    public void register(SecondBoard board) throws Exception{
        repository.save(board);
    }

}
