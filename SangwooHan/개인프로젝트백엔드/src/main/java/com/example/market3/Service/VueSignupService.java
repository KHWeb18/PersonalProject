package com.example.market3.Service;

import com.example.market3.Entity.Signup;

import java.util.List;

public interface VueSignupService {
    public void register(Signup signup) throws Exception;

    public List<Signup> list() throws Exception;
}
