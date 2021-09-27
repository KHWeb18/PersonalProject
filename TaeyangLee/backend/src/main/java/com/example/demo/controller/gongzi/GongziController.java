package com.example.demo.controller.gongzi;

import com.example.demo.entity.Board;
import com.example.demo.entity.Gongzi;
import com.example.demo.service.BoardService;
import com.example.demo.service.GongziService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/gongzi")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class GongziController {

    @Autowired
    private GongziService service;

    @PostMapping("/register")
    public ResponseEntity<Gongzi> register(@Validated @RequestBody Gongzi gongzi) throws Exception {
        log.info("post register request from vue");

        service.register(gongzi);

        return new ResponseEntity<>(gongzi, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Gongzi>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
    @GetMapping("/{gongziNo}")
    public ResponseEntity<Gongzi> read(@PathVariable("gongziNo") Integer gongziNo) throws Exception {
        Gongzi gongzi = service.read(gongziNo);
        log.info("getLists(): " + service.read(gongziNo));
        return new ResponseEntity<Gongzi>(gongzi, HttpStatus.OK);
    }

    @PutMapping("/{gongziNo}")
    public ResponseEntity<Gongzi> modify(@PathVariable("gongziNo") Integer gongziNo,
                                        @Validated @RequestBody Gongzi gongzi) throws Exception {
        gongzi.setGongziNo(gongziNo);
        service.modify(gongzi);
        return new ResponseEntity<Gongzi>(gongzi, HttpStatus.OK);
    }

    @DeleteMapping("/{gongziNo}")
    public ResponseEntity<Void> remove(@PathVariable("gongziNo")Integer gongziNo) throws Exception {
        service.remove(gongziNo);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }


}
