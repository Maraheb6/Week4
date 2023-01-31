package com.example.springhw17.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
