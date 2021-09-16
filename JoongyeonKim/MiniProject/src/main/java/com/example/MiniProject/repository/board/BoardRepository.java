package com.example.MiniProject.repository.board;

import com.example.MiniProject.controller.board.BoardRequest;
import com.example.MiniProject.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
