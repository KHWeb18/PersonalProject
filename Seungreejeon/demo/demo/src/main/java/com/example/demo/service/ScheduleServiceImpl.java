package com.example.demo.service;


import com.example.demo.entity.Schedule;
import com.example.demo.repository.ScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public void addSchedule(Schedule schedule) throws Exception {
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> fetchSchedule() throws Exception {
        return scheduleRepository.findAll();
    }
}
