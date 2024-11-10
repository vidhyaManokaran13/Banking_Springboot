package com.example.springboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CourseModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String CourseName;
    private String Courseduration;
    private String CourseLesson;
    private String CourseDesc;
    private double CourseFee;

}