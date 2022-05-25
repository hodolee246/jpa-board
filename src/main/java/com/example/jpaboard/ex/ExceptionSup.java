package com.example.jpaboard.ex;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionSup {

    private int errorCode;
    private String errorMessage;

    @Builder
    public ExceptionSup(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
