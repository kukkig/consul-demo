package com.example.poc.demo.model.cardless;

import lombok.Data;

import java.util.List;

@Data
public class CardlessKeyModel {
    private Limits limits;
    private List<Integer> amountValues;
    private Integer tokenExpiryDuration;
    private Integer withdrawalExpiryDuration;
}
