package com.study.dataprocessor.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.study.dataprocessor.dto.ExposureType;
import com.study.dataprocessor.dto.ResponseProcess;
import com.study.dataprocessor.util.Arranger;
import com.study.dataprocessor.util.Interleaver;
import com.study.dataprocessor.util.Separator;
import com.study.dataprocessor.util.Sorter;
import com.study.dataprocessor.util.UrlConnector;
import org.junit.jupiter.api.Test;

class ProcessServiceTest {

    private static final String SAMPLE_HTML = "<div>a1A0bB2c4D3Epokcjmvnv;qiowp[e1!0&@*1(6^&2_4*(333!5&*2#_6(@88+9090_!@<div>";
    private final ProcessService processService = new ProcessService(new UrlConnector(), new Arranger(new Separator(), new Sorter()), new Interleaver());

    @Test
    void serviceRemoveHtmlTest() {
        final ResponseProcess response = processService.parse(SAMPLE_HTML, ExposureType.REMOVE_HTML, 8);

        assertAll(
            () -> assertThat(response.getQuotient()).isEqualTo("A0a0B0b0c1c1D1E2e2i2j3k3m3n3o4o4p5p6q6v8"),
            () -> assertThat(response.getRemainder()).isEqualTo("v8w99")
        );
    }

    @Test
    void serviceAllTextTest() {
        final ResponseProcess response = processService.parse(SAMPLE_HTML, ExposureType.ALL_TEXT, 8);

        assertAll(
            () -> assertThat(response.getQuotient()).isEqualTo("A0a0B0b0c1c1D1d2d2E2e3i3i3i3j4k4m5n6o6o8p8p9q9vv"),
            () -> assertThat(response.getRemainder()).isEqualTo("vvw")
        );
    }
}
