package com.jmc.springapi.test.controller;


import com.jmc.springapi.test.dto.TestDto;
import com.jmc.springapi.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    public static final String LIST_KEY="list";
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value="test", cacheManager="cacheManager", key="#root.target.LIST_KEY")
    public List<TestDto.TestResponse> getTests() {
        return testService.getTests();
    }

    @GetMapping("/test/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CacheEvict(value="test", cacheManager="cacheManager", key="#root.target.LIST_KEY")
    public TestDto.TestResponse getTest(@PathVariable("id") long id) {
        return testService.getTest(id);
    }
}