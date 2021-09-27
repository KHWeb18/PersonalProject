package com.example.Mini.entity.food;

import com.example.Mini.entity.member.MemberAuth;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_no")
    private int foodNo;
    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String gradeSelect;

    @Column(length = 64, nullable = false)
    private String glutenFree;

    @Column(length = 64, nullable = false)
    private String ageSelect;

    @Column(length = 64, nullable = false)
    private String protein;

    @Column(length = 64, nullable = false)
    private String fat;

    @Column(length = 64, nullable = false)
    private String mineral;

    @Column(length = 64, nullable = false)
    private String fiber;

    @Column(length = 64, nullable = false)
    private String moisture;

    @Column(length = 64, nullable = false)
    private String calcium;

    @Column(length = 64, nullable = false)
    private String phosphorus;

    @Column(length = 64, nullable = false)
    private String kcal;

    @Column(length = 64, nullable = false)
    private String diarhea;

    @Column(length = 64, nullable = false)
    private String hairball;

    @Column(length = 64, nullable = false)
    private String palatability;

    @Column(length = 64, nullable = false)
    private String coat;



    @Column(length = 160)
    private String introduce;

    public Food(String name, String gradeSelect, String glutenFree, String ageSelect, String protein, String fat, String mineral
            , String fiber, String moisture, String calcium, String phosphorus, String kcal, String introduce,
                String diarhea, String hairball, String coat, String palatability) {
        this.name = name;
        this.gradeSelect = gradeSelect;
        this.glutenFree = glutenFree;
        this.ageSelect = ageSelect;
        this.protein = protein;
        this.fat = fat;
        this.mineral = mineral;
        this.fiber = fiber;
        this.moisture = moisture;
        this.calcium = calcium;
        this.phosphorus = phosphorus;
        this.kcal = kcal;
        this.introduce = introduce;
        this.diarhea = diarhea;
        this.hairball = hairball;
        this.coat = coat;
        this.palatability = palatability;









    }
}