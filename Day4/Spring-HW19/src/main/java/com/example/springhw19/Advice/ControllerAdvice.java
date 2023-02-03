package com.example.springhw19.Advice;

import com.example.springhw19.ApiException.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity ApiException(MethodArgumentNotValidException e){
        String message=e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public  ResponseEntity ApiEception(SQLIntegrityConstraintViolationException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
