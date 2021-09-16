package com.example.demo.service;



import com.example.demo.entity.Calendar;

import java.util.List;

public interface CalendarService {

    public void addCalendar(Calendar calendar) throws Exception;

    public List<Calendar> fetchCalendar() throws Exception;

    public void deleteCalendar(Long boardNo) throws Exception;
}
