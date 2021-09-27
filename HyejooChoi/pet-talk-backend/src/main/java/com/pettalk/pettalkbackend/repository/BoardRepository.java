package com.pettalk.pettalkbackend.repository;

import com.pettalk.pettalkbackend.entity.Board;
import com.pettalk.pettalkbackend.repository.custom.BoardRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    Page<Board> findAll(Pageable pageable);
}
