package com.jmc.springapi.test.controller;


import com.jmc.springapi.test.dto.TestDto;
import com.jmc.springapi.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public List<TestDto.TestResponse> getTests() {
        return testService.getTests();
    }
}