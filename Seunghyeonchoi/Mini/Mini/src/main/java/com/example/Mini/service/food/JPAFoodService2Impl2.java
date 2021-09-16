package com.example.Mini.service.food;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.entity.board.Notice;
import com.example.Mini.repository.food.JPAFoodRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class JPAFoodService2Impl2 implements JPAFoodService2 {

    @Autowired
    private JPAFoodRepository2 repository;


    @Override
    public List<FoodRequest> list() throws Exception {
        return repository.list();
    }

    @Override
    public FoodRequest read(int foodNo) throws Exception {
        return repository.read(foodNo);
    }

}