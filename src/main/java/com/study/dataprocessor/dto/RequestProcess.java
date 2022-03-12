package com.study.dataprocessor.dto;

import lombok.Getter;

@Getter
public class RequestProcess {
    private String url;
    private ExposureType exposureType;
    private Integer unitCount;
}
