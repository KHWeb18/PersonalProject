package com.example.writer.controller;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor

public class CategoryRequest {
    private String email;
    private String category;

}
