package com.example.springboot.controler;

import com.example.springboot.Model.Accountmodel;
import com.example.springboot.Model.TransactionModel;
import com.example.springboot.service.Accountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Account")
public class Accountcontroller {
@Autowired
Accountservice accountservice;


@PostMapping("/createAccount")
    public Accountmodel createAccount(@RequestBody Accountmodel accountmodel){
        return accountservice.create(accountmodel);
    }

@PostMapping("/withdraw/{id}")
public String withdraw(@PathVariable long id, @RequestParam("amount") BigDecimal amount){
    return accountservice.withdrawAmount(id,amount);
}
    @PostMapping("/deposit/{id}")
    public String deposit(@PathVariable Long id, @RequestParam("amount")BigDecimal amount){
        return accountservice.depositAmount(id,amount);
    }
    //Balance how much having
 @GetMapping("/getbalance/{id}")
 public String getBalance(@PathVariable Long id){
    return accountservice.getbalance(id);

 }
 @GetMapping("/gettransactionhistorybyId/{id}")
    public List<TransactionModel> getTransactionHistory(@PathVariable Long id){
    return accountservice.getTransactionHistory(id);
 }

}
