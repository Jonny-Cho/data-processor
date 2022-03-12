package com.study.dataprocessor.dto;

import java.util.function.Function;
import lombok.Getter;

@Getter
public enum ExposureType {
    REMOVE_HTML(str -> str.replaceAll(Constants.REMOVE_TAG_PATTERN, Constants.EMPTY)),
    ALL_TEXT(str -> str);

    private Function<String, String> function;

    ExposureType(final Function<String, String> function) {
        this.function = function;
    }

    public String getExposedHtml(final String str) {
        return function.apply(str);
    }

    private static class Constants {

        private static final String REMOVE_TAG_PATTERN = "<[^>]*>";
        private static final String EMPTY = "";
    }
}