package com.example.poc.demo.controller;

import com.example.poc.demo.model.ConfigData;
import com.example.poc.demo.service.CachingConsulKVService;
import com.example.poc.demo.service.GetKeyValFromConsulService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestConsulKvController {

    private GetKeyValFromConsulService getKeyValFromConsulService;
    private CachingConsulKVService cachingConsulKVService;

    public TestConsulKvController(GetKeyValFromConsulService getKeyValFromConsulService,
                                  CachingConsulKVService cachingConsulKVService) {
        this.getKeyValFromConsulService = getKeyValFromConsulService;
        this.cachingConsulKVService = cachingConsulKVService;
    }

    @GetMapping("/test")
    public ConfigData testController() throws IOException, IllegalAccessException {
        return getKeyValFromConsulService.testService();
    }

    @GetMapping("/test3")
    public ResponseEntity testThree() {
        cachingConsulKVService.testCacheConsul();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test4")
    public Object testFour() {
        return cachingConsulKVService.testJenkins();
    }
}