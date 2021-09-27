package test.modify.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import test.modify.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

}
