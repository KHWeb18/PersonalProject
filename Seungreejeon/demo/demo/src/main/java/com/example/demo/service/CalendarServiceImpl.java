package com.example.demo.service;


import com.example.demo.entity.Calendar;
import com.example.demo.repository.CalendarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public void addCalendar(Calendar calendar) throws Exception {
        calendarRepository.save(calendar);
    }

    @Override
    public List<Calendar> fetchCalendar() throws Exception {
        return calendarRepository.findAll();
    }

    @Override
    public void deleteCalendar(Long calenderNo) throws Exception {
        calendarRepository.deleteById(calenderNo);
    }
}
