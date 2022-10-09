package com.nahid.simpleboot.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("error_message")
    String errorMsg;

    @JsonProperty("status_code")
    Integer statusCode;

    public ErrorResponse(Integer statusCode , String message) {
        this.statusCode = statusCode;
        this.errorMsg = message;
    }
}
