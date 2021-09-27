package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.Gongzi;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.GongziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GongziServiceImpl implements GongziService {

    @Autowired
    private GongziRepository repository;

    @Override
    public void register(Gongzi gongzi) throws Exception {
        repository.create(gongzi);
    }

    @Override
    public List<Gongzi> list() throws Exception {
        return repository.list();
    }

    @Override
    public Gongzi read(Integer gongziNo) throws Exception {
        return repository.read(gongziNo);
    }

    @Override
    public void remove(Integer gongziNo) throws Exception {
        repository.delete(gongziNo);
    }

    @Override
    public void modify(Gongzi gongzi) throws Exception {
        repository.update(gongzi);
    }
}