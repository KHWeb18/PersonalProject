package com.example.Mini.service.food;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.entity.food.Food;
import com.example.Mini.repository.food.JPAFoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class JPAFoodServiceImpl implements JPAFoodService {

    @Autowired
    private JPAFoodRepository foodRepository;

    @Autowired
    private HttpSession session;

    @Override
    public void register(FoodRequest foodRequest) throws Exception {

        Food foodEntity = new Food(foodRequest.getName(), foodRequest.getGradeSelect(), foodRequest.getGlutenFree(), foodRequest.getAgeSelect()
                , foodRequest.getProtein(), foodRequest.getFat(), foodRequest.getMineral(), foodRequest.getFiber(), foodRequest.getMoisture()
                , foodRequest.getCalcium(), foodRequest.getPhosphorus(), foodRequest.getKcal(), foodRequest.getIntroduce(),
                foodRequest.getDiarhea(), foodRequest.getHairball(), foodRequest.getCoat(), foodRequest.getPalatability());

        foodRepository.save(foodEntity);
    }

    @Override
    public void findFoodNo(String name) throws Exception {
        foodRepository.findFoodNo(name);

        int no = foodRepository.findFoodNo(name);

        log.info("**foodNo??? from impl : " + no);

        session.setAttribute("registerNo", no);


    }
}