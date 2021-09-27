package com.example.MiniProject.service.funding;

import com.example.MiniProject.controller.funding.FundingRequest;
import com.example.MiniProject.entity.funding.Funding;
import com.example.MiniProject.repository.funding.FundingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FundingServiceImpl implements FundingService {

    @Autowired
    private FundingRepository fundingRepository;

    @Override
    public void register(FundingRequest fundingRequest) throws Exception {

        Funding fundingEntity = new Funding(fundingRequest.getCategory(), fundingRequest.getWriter(),
                fundingRequest.getTitle(), fundingRequest.getImage(), fundingRequest.getSummary(),
                fundingRequest.getContent(), fundingRequest.getFundingEnd(), fundingRequest.getEndMoney(),
                fundingRequest.getNowMoney());

        fundingRepository.save(fundingEntity);

    }

    @Override
    public List<Funding> lists() throws Exception {
        return fundingRepository.findAll();
    }

    @Override
    public Funding read(Long fundingNo) throws Exception {

        List<Funding> fundingRead = fundingRepository.findByFunding(fundingNo);

        return fundingRead.get(0);
    }

    @Override
    public void remove(Long fundingNo) throws Exception {
        //Optional<Funding> fundingDelete = fundingRepository.deleteByFunding(fundingNo);

        //return fundingDelete.get(0);

        fundingRepository.deleteById(fundingNo);
    }

    @Override
    public void modify(Funding funding, FundingRequest fundingRequest) throws Exception {

        funding.updateFunding(fundingRequest);
        fundingRepository.save(funding);
    }

    @Override
    public void payMoney(Funding funding, FundingRequest fundingRequest) throws Exception {

        funding.payFundingRequest(fundingRequest);
        fundingRepository.save(funding);
    }
}
