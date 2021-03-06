package com.example.jsmain.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecoendVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest() {
        log.info("getVueForTest(): 뷰로 for문을 맥이자!");

        return "/vue/second";
    }
}
