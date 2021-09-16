package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.Gongzi;

import java.util.List;


public interface GongziService {
  public void register(Gongzi gongzi) throws Exception;

  public List<Gongzi> list() throws Exception;

  public Gongzi read(Integer gongziNo) throws Exception;

  public void remove(Integer gongziNo) throws Exception;

  public void modify(Gongzi gongzi) throws Exception;


}
