package com.example.restdemo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientErrorResponse {

    @JsonProperty("result")
    private Result result;

    @JsonProperty("message")
    private String message;

}
