package com.example.poc.demo.model.cardless;

import lombok.Data;

@Data
public class Limits {
    private Integer perTransaction;
    private Integer dailyTransaction;
    private Integer numberOfTransactions;
    private Integer maxAmount;
    private Integer minAmount;
}
