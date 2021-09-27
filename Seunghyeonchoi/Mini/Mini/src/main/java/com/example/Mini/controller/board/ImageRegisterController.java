package com.example.Mini.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ImageRegisterController {


    @PostMapping("/admin/uploadImg_Food")
    @ResponseBody
    public String requestUploadFile(
            @RequestParam("fileList") List<MultipartFile> fileList,
            @RequestParam("no") String no) {
        try {
            for (MultipartFile multipartFile : fileList) {

                FileOutputStream writer = new FileOutputStream("./images/food/"+ no + ".gif");


                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail";
        }

        log.info("Food Image Upload Success || Image name : " + no + ".jpg");

        return "Upload Success";
    }

    @PostMapping("/admin/uploadImg_Notice")
    @ResponseBody
    public String requestUploadFile2(
            @RequestParam("fileList") List<MultipartFile> fileList,
            @RequestParam("id") String id,
            @RequestParam("no") String no) {

        log.info("requestUploadFile(): " + fileList);
        log.info("**params value( id ) : " + id);
        log.info("**params value( no ) : " + no);

        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("./images/notice/"+ id + "_" + no + ".gif");
                log.info("multipartFile.getOriginalFilename : " + multipartFile.getOriginalFilename());


                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }
        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }

    @PostMapping("/admin/uploadImg_Free")
    @ResponseBody
    public String requestUploadFile3(
            @RequestParam("fileList") List<MultipartFile> fileList,
            @RequestParam("id") String id,
            @RequestParam("no") String no) {

        log.info("requestUploadFile(): " + fileList);
        log.info("**params value( id ) : " + id);
        log.info("**params value( no ) : " + no);

        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("./images/free/"+ id + "_" + no + ".gif");
                log.info("multipartFile.getOriginalFilename : " + multipartFile.getOriginalFilename());


                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }

    @PostMapping("/admin/uploadImg_Profile")
    @ResponseBody
    public String requestUploadFile3(
            @RequestParam("fileList") List<MultipartFile> fileList,
            @RequestParam("id") String userId) {

        log.info("requestUploadFile(): " + fileList);
        log.info("**params value( id ) : " + userId);

        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("./images/profile/"+ userId + ".gif");
                log.info("multipartFile.getOriginalFilename : " + multipartFile.getOriginalFilename());


                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }
}