package com.example.springboot.Repositary;

import com.example.springboot.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositary extends JpaRepository<CourseModel,Integer> {
}
