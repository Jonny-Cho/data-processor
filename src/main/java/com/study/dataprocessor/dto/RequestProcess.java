package com.study.dataprocessor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestProcess {
    private final String url;
    private final ExposureType exposureType;
    private final Integer unitCount;
}
