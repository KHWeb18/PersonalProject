package com.example.writer.service;

import com.example.writer.entity.User;

public interface UserService {

    public boolean register(User user) throws Exception;


    public Integer login(User user) throws Exception;

    public boolean checkUserIdValidation(String userEmail) throws Exception;
}
