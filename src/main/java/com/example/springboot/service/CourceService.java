package com.example.springboot.service;

import com.example.springboot.Model.CourseModel;
import com.example.springboot.Repositary.CourseRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CourceService {
    @Autowired
    CourseRepositary corserepository ;

    public CourseModel create(CourseModel coursemodel){
     return corserepository.save(coursemodel);
    }
}
