package com.study.dataprocessor.dto;

import lombok.Getter;

@Getter
public class ResponseProcess {
    private String quotient;
    private String remainder;

    public ResponseProcess(final OutputUnit outputUnit) {
        this.quotient = outputUnit.getQuotient();
        this.remainder = outputUnit.getRemainder();
    }
}
