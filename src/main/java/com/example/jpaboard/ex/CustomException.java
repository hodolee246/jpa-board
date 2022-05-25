package com.example.jpaboard.ex;

import lombok.Getter;
import org.springframework.http.HttpStatus;

//예외 전환방식 사용
@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final int errorCode;
    private final String errorMessage;

    public CustomException(HttpStatus httpStatus, int errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
