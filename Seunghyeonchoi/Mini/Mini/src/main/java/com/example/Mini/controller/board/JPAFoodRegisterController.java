package com.example.Mini.controller.board;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.controller.member.request.NoticeRequest;
import com.example.Mini.controller.member.session.UserInfo;
import com.example.Mini.service.food.JPAFoodService;
import com.example.Mini.service.member.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/operator")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAFoodRegisterController {
    //FoodRegister용 컨트롤러

    @Autowired
    private JPAFoodService service;

    @Autowired
    private HttpSession session;

    @PostMapping("/foodRegister")
    public ResponseEntity<FoodRequest> jpaRegister(
            @Validated @RequestBody FoodRequest foodRequest) throws Exception {

//        log.info("jpaRegister(): " + foodRequest.getName() + ", " + foodRequest.getGradeSelect() + ", " + foodRequest.getGlutenFree() + ", " +
//                foodRequest.getAge() + ", " + foodRequest.getProtein() + ", " + foodRequest.getFat() + ", " + foodRequest.getMineral() + ", " +
//                foodRequest.getFiber() + ", " + foodRequest.getMoisture() + ", " + foodRequest.getClass() + ", " + foodRequest.getPhosphorus() +
//                ", " + foodRequest.getKcal() + ", " + foodRequest.getIntroduce());
        log.info("vue에서 받아온 food정보 : " + foodRequest);

        service.register(foodRequest);

        String name = foodRequest.getName();

        FoodRequest request = new FoodRequest();

        service.findFoodNo(name);

        int no = (int) session.getAttribute("registerNo");

        System.out.println("===Food Register Controller===");
        System.out.println("세션에 저장 되 있는 변수 : "+no);
        System.out.println("==============================");
        foodRequest.setFoodNo(no);

        return new ResponseEntity<>(foodRequest, HttpStatus.OK);
    }
}