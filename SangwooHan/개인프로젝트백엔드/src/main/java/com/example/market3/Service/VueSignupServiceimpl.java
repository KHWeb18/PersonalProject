package com.example.market3.Service;

import com.example.market3.Entity.Signup;
import com.example.market3.Rapository.VueSignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueSignupServiceimpl implements  VueSignupService {

    @Autowired
    VueSignupRepository repository;

    @Override
    public void register(Signup signup) throws Exception {
      repository.create(signup);
    }

    @Override
    public List<Signup> list() throws Exception {
        return repository.list();
    }
}
