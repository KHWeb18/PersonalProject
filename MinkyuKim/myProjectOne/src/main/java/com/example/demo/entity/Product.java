package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {
    private int productNo;
    private String product_name;
    private String description;
    private String producer;
    private int price;
    private String files;
    private Date regDate;

}