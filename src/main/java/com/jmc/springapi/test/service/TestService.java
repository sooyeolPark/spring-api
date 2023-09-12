package com.jmc.springapi.test.service;

import java.util.List;
import java.util.stream.Collectors;

import com.jmc.springapi.test.dto.TestDto;
import com.jmc.springapi.test.repository.TestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestService {

    private final TestRepository testRepository;

    public List<TestDto.TestResponse> getTests() {
        List<TestDto.TestResponse> res = testRepository.findAll()
                .stream()
                .map(TestDto.TestResponse::of)
                .collect(Collectors.toList());
        return res;
    }
}