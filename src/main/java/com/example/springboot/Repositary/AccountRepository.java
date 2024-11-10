package com.example.springboot.Repositary;

import com.example.springboot.Model.Accountmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountrepository extends JpaRepository<Accountmodel,Long> {
}
