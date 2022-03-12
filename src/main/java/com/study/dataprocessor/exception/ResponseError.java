package com.study.dataprocessor.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseError {
    private final String errorMessage;
    private final String errorCode;
}
