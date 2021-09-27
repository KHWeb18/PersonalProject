package com.example.Mini.controller.board;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.entity.board.Notice;
import com.example.Mini.service.food.JPAFoodService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/foodboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FoodController {
    //FoodList용 컨트롤러

    @Autowired
    private JPAFoodService2 service;

    @GetMapping("/lists")
    public ResponseEntity<List<FoodRequest>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{foodNo}")
    public ResponseEntity<FoodRequest> read(@PathVariable("foodNo") Integer foodNo) throws Exception {

        FoodRequest food = service.read(foodNo);

        return new ResponseEntity<FoodRequest>(food, HttpStatus.OK);
    }


}