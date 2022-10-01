package com.slip.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;


@Getter
public class ErrorResponse {

    private final String code;
    private final String message;
    private Map<String,String> validation;

    @Builder
    public ErrorResponse(String code, String message,Map<String,String> validation){
        this.code = code;
        this.message =message;
        this.validation = validation;
    }

    public void addValidation(String fileName, String errorMessage){
        this.validation.put(fileName,errorMessage);
    }
}
