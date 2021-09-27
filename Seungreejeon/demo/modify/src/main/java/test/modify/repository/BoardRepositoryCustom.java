package test.modify.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.modify.controller.BoardDto;

public interface BoardRepositoryCustom {

    Page<BoardDto> searchPageSimple(EmployeeCondition condition, Pageable pageable);
}
