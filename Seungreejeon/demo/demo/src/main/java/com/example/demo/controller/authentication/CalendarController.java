package com.example.demo.controller.authentication;


import com.example.demo.entity.Calendar;
import com.example.demo.entity.Project;
import com.example.demo.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/calendar")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @PostMapping("/add-calendar")
    public ResponseEntity<Calendar> addCalendar(@RequestBody Calendar calendar) throws Exception {
        log.info("add-calendar() : " + calendar.toString());

        calendarService.addCalendar(calendar);

        return new ResponseEntity<Calendar>(HttpStatus.OK);
    }

    @GetMapping("/fetch-calendar")
    public ResponseEntity<List<Calendar>> fetchCalendar() throws Exception {
        log.info("fetch-Calendar() : ");

        List<Calendar> fetchCalendar = calendarService.fetchCalendar();

        return new ResponseEntity<List<Calendar>>(fetchCalendar, HttpStatus.OK);
    }

    @DeleteMapping("/delete-calendar/{calendarNo}")
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long calendarNo) throws Exception {
        log.info("delete-Calendar() : ");

        calendarService.deleteCalendar(calendarNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
