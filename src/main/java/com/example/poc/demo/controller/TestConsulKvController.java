package com.example.poc.demo.controller;

import com.example.poc.demo.model.ConfigData;
import com.example.poc.demo.service.GetKeyValFromConsulService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConsulKvController {

    private GetKeyValFromConsulService getKeyValFromConsulService;

    public TestConsulKvController(GetKeyValFromConsulService getKeyValFromConsulService) {
        this.getKeyValFromConsulService = getKeyValFromConsulService;
    }

    @GetMapping("/test")
    public ConfigData testController() throws JsonProcessingException, IllegalAccessException {
        return getKeyValFromConsulService.testService();
    }
}
