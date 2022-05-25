package com.example.jpaboard.ex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> exceptionHandler(CustomException ex) {
        ExceptionSup responseException = ExceptionSup.builder()
                .errorMessage(ex.getErrorMessage())
                .errorMessage(ex.getErrorMessage())
                .build();

        return new ResponseEntity<>(responseException, ex.getHttpStatus());
    }

}
