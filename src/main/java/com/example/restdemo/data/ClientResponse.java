package com.example.restdemo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Builder
public class ClientResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("result")
    private Result result;

    @JsonProperty("message")
    private String message;

    @JsonProperty("filial")
    private String filial;
}
