package com.example.jpaboard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        log.warn("e.getCause: {}", e.getCause());
    }

}
