package com.example.springboot.controler;


import com.example.springboot.Model.CourseModel;
import com.example.springboot.service.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseControler {
    @Autowired
    CourceService courseservice;
    @PostMapping("/autocourse")
     public CourseModel createcpurse(@RequestBody CourseModel cc){
         return courseservice.create(cc);
     }
}
