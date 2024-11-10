package com.example.springboot.Repositary;

import com.example.springboot.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel,Long> {
@Query("Seclect t from Transaction_Model where t.account_id=  :id")
    List<TransactionModel> getTransactionHistory(Long id);


}
