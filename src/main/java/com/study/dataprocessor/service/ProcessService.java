package com.study.dataprocessor.service;

import com.study.dataprocessor.dto.RequestProcess;
import com.study.dataprocessor.dto.ResponseProcess;
import com.study.dataprocessor.util.UrlConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final UrlConnector urlConnector;

    public ResponseProcess parse(final RequestProcess request) {
        final String html = urlConnector.getHtml(request.getUrl());
        return null;
    }
}
