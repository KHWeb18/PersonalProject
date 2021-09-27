package com.example.Mini.service.food;

import com.example.Mini.controller.member.request.FoodRequest;

public interface JPAFoodService {
    public void register(FoodRequest foodRequest) throws Exception;

    public void findFoodNo(String name) throws Exception;
}