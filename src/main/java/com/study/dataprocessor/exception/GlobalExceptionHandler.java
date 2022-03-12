package com.study.dataprocessor.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError> methodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        return ResponseEntity
            .badRequest()
            .body(new ResponseError(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), "E001"));
    }

    @ExceptionHandler(UrlConnectionError.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError> urlConnectionError(final UrlConnectionError e) {
        log.error(e.getMessage());
        return ResponseEntity
            .badRequest()
            .body(new ResponseError(e.getMessage(), "E002"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError> httpMessageNotReadableException(final HttpMessageNotReadableException e) {
        log.error(e.getMessage());
        return ResponseEntity
            .badRequest()
            .body(new ResponseError(e.getMessage(), "E003"));
    }

}
