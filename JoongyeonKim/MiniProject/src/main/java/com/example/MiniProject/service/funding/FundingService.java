package com.example.MiniProject.service.funding;


import com.example.MiniProject.controller.funding.FundingRequest;
import com.example.MiniProject.entity.funding.Funding;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface FundingService {

    public void register(FundingRequest fundingRequest) throws Exception;

    public List<Funding> lists() throws Exception;

    public Funding read(Long fundingNo) throws Exception;

    public void remove(Long fundingNo) throws Exception;

    public void modify(Funding funding, FundingRequest fundingRequest) throws Exception;


    public void payMoney(Funding funding, FundingRequest fundingRequest) throws Exception;


}
