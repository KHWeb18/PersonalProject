package com.example.demo.controller;


import com.example.demo.entity.Board;
import com.example.demo.entity.Project;
import com.example.demo.entity.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    ScheduleRepository scheduleRepository;


    @PostMapping("/add-schedule")
    public ResponseEntity<Schedule> getProject(@RequestBody Schedule schedule) throws Exception {

        log.info("add-schedule() : " + schedule.toString());

        scheduleService.addSchedule(schedule);

        return new ResponseEntity<Schedule>(HttpStatus.OK);
    }

    @GetMapping("/fetch-schedule")
    public ResponseEntity<List<Schedule>> getSchedule() throws Exception {

        log.info("fetch-schedule() : ");

        List<Schedule> fetchSchedule =  scheduleService.fetchSchedule();

        return new ResponseEntity<List<Schedule>>(fetchSchedule,HttpStatus.OK);
    }


    @PutMapping("/modify/{scheduleNo}")
    public ResponseEntity<Schedule> modify(@RequestBody Schedule schedule,
                                        @PathVariable("scheduleNo") Long scheduleNo) throws Exception {

        log.info("modify() : " + scheduleNo + "Schedule : " + schedule.toString());

        Optional<Schedule> modify = scheduleRepository.findById(scheduleNo);

        modify.ifPresent(selectSchedule -> {
            selectSchedule.setTime8(schedule.getTime8());
            selectSchedule.setTime9(schedule.getTime9());
            selectSchedule.setTime10(schedule.getTime10());
            selectSchedule.setTime11(schedule.getTime11());
            selectSchedule.setTime12(schedule.getTime12());
            selectSchedule.setTime13(schedule.getTime13());
            selectSchedule.setTime14(schedule.getTime14());
            selectSchedule.setTime15(schedule.getTime15());
            selectSchedule.setTime16(schedule.getTime16());
            selectSchedule.setTime17(schedule.getTime17());
            selectSchedule.setTime18(schedule.getTime18());
            selectSchedule.setTime19(schedule.getTime19());
            selectSchedule.setTime20(schedule.getTime20());

            scheduleRepository.save(selectSchedule);
        });
        return new ResponseEntity<Schedule>(HttpStatus.OK);
    }

}
