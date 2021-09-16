package com.example.demo.service;


import com.example.demo.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    public void addSchedule(Schedule schedule) throws Exception;

    public List<Schedule> fetchSchedule() throws Exception;
//
//    public void deleteProject(Long boardNo) throws Exception;
}
