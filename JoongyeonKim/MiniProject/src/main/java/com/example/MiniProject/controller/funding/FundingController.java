package com.example.MiniProject.controller.funding;


import com.example.MiniProject.entity.funding.Funding;
import com.example.MiniProject.repository.funding.FundingRepository;
import com.example.MiniProject.service.funding.FundingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/funding")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FundingController {

    @Autowired
    private FundingService service;

    @Autowired
    private FundingRepository repository;

    @PostMapping("/basic")
    public ResponseEntity<Void> fundingCreate(
            @Validated @RequestBody FundingRequest fundingRequest) throws Exception {
        log.info("fundingCreate(): " + fundingRequest.getCategory() + ", " + fundingRequest.getTitle()
                + ", " + fundingRequest.getEndMoney()+ ", " + fundingRequest.getImage()
                + ", " + fundingRequest.getContent() + ", " + fundingRequest.getFundingEnd() + ", " + fundingRequest.getNowMoney());

        service.register(fundingRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Funding>> getLists() throws Exception {
        log.info("getLists(): " + service.lists());

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }

    @GetMapping("/{fundingNo}")
    public ResponseEntity<Funding> read(@PathVariable("fundingNo") Long fundingNo) throws Exception {
        log.info("read");

        //List<Funding> fundingRead = repository.findByFunding(fundingNo);
        //Funding funding = fundingRead.get(fundingNo);

        //funding = service.read(fundingNo);

        Funding funding = service.read(fundingNo);

        log.info("Funding Read Success");

        return new ResponseEntity<Funding>(funding, HttpStatus.OK);
    }

    @DeleteMapping("/{fundingNo}")
    public ResponseEntity<Void> remove(@PathVariable("fundingNo") Long fundingNo) throws Exception {
        service.remove(fundingNo);

        log.info("Funding Delete Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{fundingNo}")
    public ResponseEntity<Void> update(@PathVariable("fundingNo") Long fundingNo,
                                       @RequestBody FundingRequest fundingRequest) throws Exception {

        List<Funding> funding = repository.findByRead(fundingNo);
        Funding fundingRead = funding.get(0);
        service.modify(fundingRead, fundingRequest);

        log.info("Funding Update Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @PutMapping("/plusMoney/{fundingNo}")
    public ResponseEntity<Void> pay(@PathVariable("fundingNo") Long fundingNo,
                                    @RequestBody FundingRequest fundingRequest) throws Exception {

        List<Funding> funding = repository.plusByMoney(fundingNo);
        Funding plusByMoney = funding.get(0);
        service.payMoney(plusByMoney, fundingRequest);

        log.info("Funding Pay Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
