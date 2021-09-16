package test.modify.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.modify.repository.BoardRepository;
import test.modify.repository.EmployeeCondition;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {

    @Autowired
    private BoardRepository boardRepository;

//  http://localhost:8080/board?title=hihi&first=0&size=5

    @GetMapping("/board")
    public Result boardApi(EmployeeCondition employeeCondition, Pageable pageable) {
        Page<BoardDto> boardDtos = boardRepository.searchPageSimple(employeeCondition, pageable);

        return new Result(boardDtos);

    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
