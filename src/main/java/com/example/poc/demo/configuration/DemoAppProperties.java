package com.example.poc.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;
import java.util.Map;

@ConfigurationProperties(prefix = "consulservice.directory")
public class DemoAppProperties {
    @NotNull
    private Map<String, String> cardlessList;

    public Map<String, String> getCardlessList() { return cardlessList; }

    public void setCardlessList(Map<String, String> cardlessList) { this.cardlessList = cardlessList; }
}
