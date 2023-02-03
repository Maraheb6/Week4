package com.example.springhw19.ApiException;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
