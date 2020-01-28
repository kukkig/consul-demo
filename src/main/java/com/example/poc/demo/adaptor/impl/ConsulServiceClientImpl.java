package com.example.poc.demo.adaptor.impl;

import com.example.poc.demo.adaptor.ConsulServiceClient;
import com.example.poc.demo.model.ClientUri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
public class ConsulServiceClientImpl implements ConsulServiceClient {

    private final RestTemplate restTemplate;
    private final ClientUri clientUri;

    public ConsulServiceClientImpl(RestTemplate restTemplate, ClientUri clientUri) {
        this.restTemplate = restTemplate;
        this.clientUri = clientUri;
    }

    @Override
    public Object get(String key) {
        log.info("Getting Data from Consul Agent: uri=[{}]", clientUri.getGetUri());

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(clientUri.getGetUri())
                .queryParam("raw", true)
                .buildAndExpand(key);
        log.info("Built Uri: uri=[{}]", builder.toUriString());

        Object response = restTemplate.getForObject(builder.toUriString(), String.class);
        log.info("Consul response: response=[{}]", response);
        return response;
    }
}
