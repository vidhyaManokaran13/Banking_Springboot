package com.example.springboot.service;

import com.example.springboot.Model.Accountmodel;
import com.example.springboot.Model.TransactionModel;
import com.example.springboot.Repositary.TransactionRepository;
import com.example.springboot.Repositary.accountrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class Accountservice {

    @Autowired
    accountrepository Accountrepository;
    @Autowired
    TransactionRepository transactionRepository;

    public Accountmodel create(Accountmodel accountmodel) {
        return Accountrepository.save(accountmodel);
    }

    public String withdrawAmount(Long id, BigDecimal amount) {
        Accountmodel accountdata = Accountrepository.findById(id).orElse(null);
//if the account not found it shows this msg
        if (accountdata == null) {
            return "Account not found";
        }
//  logic- balance >amount
//  5000 - 2000
// account not have balance it shows this msge
        if (accountdata.getBalance().compareTo(amount) < 0) {
            return "low balance";
        }
        //if the accound is there subtract the amount
        accountdata.setBalance(accountdata.getBalance().subtract(amount));
        Accountrepository.save(accountdata);

        //Transaction details
        TransactionModel transactionModel=new TransactionModel();
        transactionModel.setAccountmodel(accountdata);
        transactionModel.setAmount(amount);
        transactionModel.setTransactionType("Withdraw");
        transactionModel.setTransactionTime(LocalDateTime.now());//on spote time
        transactionRepository.save(transactionModel);

        return "withdraw done";
    }
    //Deposit
    public String depositAmount(Long id,BigDecimal amount){
        Accountmodel accountdata = Accountrepository.findById(id).orElse(null);

        if (accountdata == null) {
            return "Account not found";
        }
        //add the amount
        accountdata.setBalance(accountdata.getBalance().add(amount));
        Accountrepository.save(accountdata);


        //create Transaction

        TransactionModel transactionModel=new TransactionModel();
        transactionModel.setAmount(amount);
        transactionModel.setAccountmodel(accountdata);
        transactionModel.setTransactionType("Deposit");
        transactionModel.setTransactionTime(LocalDateTime.now());//on spote time
        transactionRepository.save(transactionModel);
        return "deposit done";
    }
    public String getbalance(Long id){
        Accountmodel accountdata = Accountrepository.findById(id).orElse(null);

        if (accountdata == null) {
            return "Account not found";
        }
        return "your account balance is:"+accountdata.getBalance();
    }
    public List<TransactionModel> getTransactionHistory(Long id){
        return transactionRepository.getTransactionHistory(id);
    }
}


