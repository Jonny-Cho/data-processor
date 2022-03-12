package com.study.dataprocessor.dto;

import lombok.Getter;

@Getter
public class ResponseProcess {
    private final String quotient;
    private final String remainder;

    public ResponseProcess(final OutputUnit outputUnit) {
        this.quotient = outputUnit.getQuotient();
        this.remainder = outputUnit.getRemainder();
    }
}
