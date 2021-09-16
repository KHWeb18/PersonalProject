package com.example.Mini.controller.member.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class FoodRequest {
    private int foodNo;
    private String name;
    private String gradeSelect;
    private String glutenFree;
    private String ageSelect;
    private String protein;
    private String fat;
    private String mineral;
    private String fiber;
    private String moisture;
    private String calcium;
    private String phosphorus;
    private String kcal;
    private String introduce;
    private String diarhea;
    private String hairball;
    private String coat;
    private String palatability;
}