package com.example.poc.demo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClientUri {
    @NotNull
    private String baseUri;

    @NotNull
    private String getUri;
}
