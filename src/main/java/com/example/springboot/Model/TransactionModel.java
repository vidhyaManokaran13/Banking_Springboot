package com.example.springboot.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class TransactionModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Accountmodel getAccountmodel() {
        return accountmodel;
    }

    public void setAccountmodel(Accountmodel accountmodel) {
        this.accountmodel = accountmodel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // to connect the account model join to transaction model
    @ManyToOne

    @JoinColumn(name="accountid",nullable = false)
  private Accountmodel accountmodel;
    private BigDecimal amount;

    private LocalDateTime transactionTime;
    private String transactionType;
}
