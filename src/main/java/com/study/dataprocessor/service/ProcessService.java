package com.study.dataprocessor.service;

import com.study.dataprocessor.dto.OutputUnit;
import com.study.dataprocessor.dto.RequestProcess;
import com.study.dataprocessor.dto.ResponseProcess;
import com.study.dataprocessor.util.Arranger;
import com.study.dataprocessor.util.Interleaver;
import com.study.dataprocessor.util.UrlConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final UrlConnector urlConnector;
    private final Arranger arranger;
    private final Interleaver interleaver;

    public ResponseProcess parse(final RequestProcess request) {
        final String html = urlConnector.getHtml(request.getUrl());
        final String exposedHtml = request.getExposureType().getExposedHtml(html);
        final Arranger rearrange = arranger.rearrange(exposedHtml);
        final String rearrangedStr = interleaver.interleave(rearrange);
        final OutputUnit outputUnit = new OutputUnit(rearrangedStr, request.getUnitCount());
        return new ResponseProcess(outputUnit);
    }
}
