package com.study.dataprocessor.controller;

import com.study.dataprocessor.dto.RequestProcess;
import com.study.dataprocessor.dto.ResponseProcess;
import com.study.dataprocessor.service.ProcessService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataProcessController {

    private final ProcessService processService;

    @PostMapping("process")
    public ResponseEntity<ResponseProcess> process(@RequestBody @Valid final RequestProcess request) {
        final ResponseProcess result = processService.parse(request);
        return ResponseEntity.ok().body(result);
    }
}
