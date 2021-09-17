package com.example.writer.repository;


import com.example.writer.entity.MyPageBoard;
import com.example.writer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyPageBoardRepository extends JpaRepository<MyPageBoard,Long> {

    List<MyPageBoard> findByCategoryNoAndUserNo(Long categoryNo ,Long userNo);

    List<MyPageBoard> findByCategoryNo(Long categoryNo);

}
