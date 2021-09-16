package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueFileController {

    @PostMapping("/uploadImg")
    @ResponseBody
    public String requestUploadFile(
            // @RequestParam("fileList") List<MultipartFile> fileList) {
            @RequestParam("fileList") List<MultipartFile> fileList)  {

        log.info("requestUploadFile(): " + fileList);

        try {
            // 파일명이 같을 수 있으므로
            // 결국 저장되는 위치가 images/ 사진파일명.확장자
            // images/아이디/사진파일명.확장자로 저장되게 vue에서 처리
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                //FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                //FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                FileOutputStream writer = new FileOutputStream("C:\\Users\\980st\\java_work\\LectureContents\\javascript\\MinkyuKim\\front_mini\\src\\assets\\imgproduct/" + multipartFile.getOriginalFilename());
                // "C:\\java_work\\LectureContents\\javascript\\MinkyuKim\\front_mini\\src\\assets\\img"
                writer.write(multipartFile.getBytes());
                writer.close();
            }

            /*
            FileOutputStream writer = new FileOutputStream("./images/" + fileList.getOriginalFilename());
            writer.write(fileList.getBytes());
            writer.close();
             */
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }
}
