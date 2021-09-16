package com.example.Mini.service.food;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.entity.board.Notice;

import java.util.List;

public interface JPAFoodService2 {
    public List<FoodRequest> list() throws Exception;

    public FoodRequest read(int foodNo) throws Exception;
}