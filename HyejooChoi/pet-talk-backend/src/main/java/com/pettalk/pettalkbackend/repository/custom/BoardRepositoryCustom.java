package com.pettalk.pettalkbackend.repository.custom;

import com.pettalk.pettalkbackend.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {
    Page<Object[]> findAllCustom(Pageable pageable);
    List<Board> findPopularList();
}
