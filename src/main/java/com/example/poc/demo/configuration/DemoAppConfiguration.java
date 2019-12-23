package com.example.poc.demo.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties({ DemoAppProperties.class })
public class DemoAppConfiguration {
    private final DemoAppProperties appProperties;

    public DemoAppConfiguration(DemoAppProperties appProperties) { this.appProperties = appProperties; }

    @Bean
    public Map<String, String> cardlessList() { return appProperties.getCardlessList(); }
}
