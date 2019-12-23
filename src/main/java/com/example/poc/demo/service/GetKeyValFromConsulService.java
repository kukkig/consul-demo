package com.example.poc.demo.service;

import com.example.poc.demo.model.cardless.CardlessKeyModel;
import com.example.poc.demo.model.ConfigData;
import com.example.poc.demo.model.ConfigDataModel;
import com.example.poc.demo.model.cardless.Limits;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;

@Slf4j
@Service
public class GetKeyValFromConsulService {

    private final Map<String, String> cardlessList;
    private static final String CARDLESS_KEY = "cardless";

    public GetKeyValFromConsulService(Map<String, String> cardlessList) {
        this.cardlessList = cardlessList;
    }

    public ConfigData testService() throws JsonProcessingException, IllegalAccessException {
        String res = cardlessList.get(CARDLESS_KEY);
        log.info("Raw data from Consul: [{}]", res);

        ObjectMapper mapper = new ObjectMapper();
        CardlessKeyModel cardlessKeyModel = mapper.readValue(res, CardlessKeyModel.class);
        log.info("Mapped val data: [{}]", cardlessKeyModel);

        Field[] cardlessKeyFields = cardlessKeyModel.getClass().getDeclaredFields();
        Field[] limitsKeyFields = cardlessKeyModel.getLimits().getClass().getDeclaredFields();

        ConfigData configData = mapDataValue(cardlessKeyFields, cardlessKeyModel, limitsKeyFields);
        log.info("ConfigData: [{}]", configData);

        return configData;
    }

    private ConfigData mapDataValue(Field[] cardlessKeyFields, CardlessKeyModel cardlessKeyModel, Field[] limitsKeyFields) throws IllegalAccessException {
        List<ConfigDataModel> configDataModels = new ArrayList<ConfigDataModel>();

        for (Field cardlessKey : cardlessKeyFields) {
            cardlessKey.setAccessible(true);
            Object cardlessValue = cardlessKey.get(cardlessKeyModel);

            if (cardlessKey.getType().equals(Limits.class)) {
                for (Field limitKey : limitsKeyFields) {
                    limitKey.setAccessible(true);
                    Object cardlessLimitValue = limitKey.get(cardlessKeyModel.getLimits());

                    configDataModels.add(new ConfigDataModel(cardlessKey.getName() + limitKey.getName(),
                            cardlessLimitValue));
                }
            } else {
                configDataModels.add(new ConfigDataModel(cardlessKey.getName(), cardlessValue));
            }
        }

        ConfigData configData = ConfigData.builder()
                .configData(configDataModels)
                .build();
        return configData ;
    }







}
