package com.slip.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class HttplogException extends RuntimeException{
    public final Map<String, String> validation = new HashMap<>();
    public HttplogException(String message){
        super(message);
    }

    public HttplogException(String message,Throwable cause){
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fileName,String message){
        validation.put(fileName,message);
    }
}
